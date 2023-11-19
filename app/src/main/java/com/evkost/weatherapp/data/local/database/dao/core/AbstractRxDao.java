package com.evkost.weatherapp.data.local.database.dao.core;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.evkost.weatherapp.data.local.database.transaction.TransactionManager;
import com.evkost.weatherapp.data.local.database.dao.core.query.Query;
import com.evkost.weatherapp.model.entity.AbstractEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Predicate;
import java.util.function.Supplier;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;

public abstract class AbstractRxDao<T extends AbstractEntity> implements RxDao<T> {
    private final SQLiteDatabase db;
    private final TransactionManager transactionManager;
    private final String tableName;
    private final PublishSubject<UpdateInfo<T>> entityUpdateSubject;

    public AbstractRxDao(SQLiteDatabase db, TransactionManager transactionManager, String tableName) {
        this.db = db;
        this.transactionManager = transactionManager;
        this.tableName = tableName;
        this.entityUpdateSubject = PublishSubject.create();
    }

    protected abstract ContentValues entityToContentValues(T entity);

    protected abstract T parseCursor(Cursor entity);

    @Override
    public final Single<Long> insert(T entity) {
        return singleQuery(() -> {
            long id = db.insertWithOnConflict(
                    tableName,
                    null,
                    entityToContentValues(entity),
                    SQLiteDatabase.CONFLICT_REPLACE
            );

            entity.setId(id);
            notifyEntityUpdated(UpdateInfo.updatedEntity(entity));
            return id;
        });
    }

    @Override
    public final Single<List<Long>> insertAll(List<T> entities) {
        return transactionManager.transactionSingle(() ->
                Observable.fromIterable(entities)
                        .flatMapSingle(this::insert)
                        .toList()
        );
    }

    @Override
    public final Maybe<T> find(Query query) {
        return maybeQuery(() -> {
            T entity = null;

            try (Cursor cursor = applyQuery(query)) {
                if (cursor.moveToFirst()) {
                    entity = parseCursor(cursor);
                }
            }

            return entity;
        });
    }

    @Override
    public final Single<List<T>> findAll(Query query) {
        return singleQuery(() -> {
            List<T> entity = new ArrayList<>();

            try (Cursor cursor = applyQuery(query)) {
                while (cursor.moveToNext()) {
                    entity.add(parseCursor(cursor));
                }
            }

            return entity;
        });
    }

    @Override
    public final Flowable<T> observe(Query query, Predicate<T> updateCondition) {
        return observableQuery(updateCondition, () -> find(query).toFlowable());
    }

    @Override
    public final Flowable<List<T>> observeAll(Query query, Predicate<T> updateCondition) {
        return observableQuery(updateCondition, () -> findAll(query).toFlowable());
    }

    @Override
    public <S> Flowable<S> observableQuery(
            Predicate<T> updateCondition,
            Supplier<Flowable<S>> singleSupplier
    ) {
        return Flowable.defer(() ->
                        Flowable.concat(
                                singleSupplier.get(),
                                entityUpdateSubject.toFlowable(BackpressureStrategy.LATEST)
                                        .filter(updateInfo -> updateInfo.mustUpdate(updateCondition))
                                        .flatMap(__ -> singleSupplier.get())
                        )
                )
                .subscribeOn(Schedulers.io());
    }

    @Override
    public final Completable delete(Query query) {
        return completableQuery(() -> {
            db.delete(tableName, query.getSelection(), query.getSelectionArgs());
            notifyEntityUpdated(UpdateInfo.updateAll());
        });
    }

    @Override
    public final Completable deleteAll() {
        return completableQuery(() -> {
            db.delete(tableName, null, null);
            notifyEntityUpdated(UpdateInfo.updateAll());
        });
    }

    private Cursor applyQuery(Query query) {
        return db.query(
                tableName,
                null,
                query.getSelection(),
                query.getSelectionArgs(),
                query.getGroupBy(),
                query.getHaving(),
                query.getOrderBy()
        );
    }

    private void notifyEntityUpdated(UpdateInfo<T> updateInfo) {
        entityUpdateSubject.onNext(updateInfo);
    }

    private Completable completableQuery(Action action) {
        return Completable.fromAction(action).subscribeOn(Schedulers.io());
    }

    private <S> Single<S> singleQuery(Callable<S> callable) {
        return Single.fromCallable(callable).subscribeOn(Schedulers.io());
    }

    private <S> Maybe<S> maybeQuery(Callable<S> callable) {
        return Maybe.defer(() -> {
            S value = callable.call();
            if (value != null) {
                return Maybe.just(value);
            }
            return Maybe.empty();
        }).subscribeOn(Schedulers.io());
    }

    private static class UpdateInfo<T> {
        private final boolean updateAll;

        private final T updatedEntity;

        private UpdateInfo() {
            this.updateAll = true;
            this.updatedEntity = null;
        }

        private UpdateInfo(T updatedEntity) {
            this.updateAll = false;
            this.updatedEntity = updatedEntity;
        }

        public static <T> UpdateInfo<T> updateAll() {
            return new UpdateInfo<>();
        }

        public static <T> UpdateInfo<T> updatedEntity(T updatedEntity) {
            return new UpdateInfo<>(updatedEntity);
        }

        public boolean mustUpdate(Predicate<T> updateCondition) {
            return updateAll || updateCondition.test(updatedEntity);
        }
    }
}