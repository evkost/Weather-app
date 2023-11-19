package com.evkost.weatherapp.data.local.database.dao.core;

import com.evkost.weatherapp.data.local.database.dao.core.query.Query;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public interface RxDao<T> {
    Single<Long> insert(T entity);

    Single<List<Long>> insertAll(List<T> entities);

    Maybe<T> find(Query query);

    Single<List<T>> findAll(Query query);

    Flowable<T> observe(Query query, Predicate<T> updateCondition);

    Flowable<List<T>> observeAll(Query query, Predicate<T> updateCondition);

    <S> Flowable<S> observableQuery(Predicate<T> updateCondition, Supplier<Flowable<S>> singleSupplier);

    Completable delete(Query query);

    Completable deleteAll();
}
