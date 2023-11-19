package com.evkost.weatherapp.data.local.database.transaction;

import android.database.sqlite.SQLiteDatabase;

import com.evkost.weatherapp.data.local.database.transaction.TransactionManager;

import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.schedulers.Schedulers;

@Singleton
public class TransactionManagerImpl implements TransactionManager {
    private final SQLiteDatabase db;

    @Inject
    public TransactionManagerImpl(SQLiteDatabase db) {
        this.db = db;
    }

    @Override
    public <T> Single<T> transactionSingle(Callable<Single<T>> callable) {
        return Single.defer(() ->{
            db.beginTransaction();
            return callable.call();
        }).doFinally(() ->{
            db.setTransactionSuccessful();
            db.endTransaction();
        }).subscribeOn(Schedulers.io());
    }

    @Override
    public <T> Flowable<T> transaction(Callable<Flowable<T>> callable) {
        return Flowable.defer(() ->{
            db.beginTransaction();
            return callable.call();
        }).doFinally(() ->{
            db.setTransactionSuccessful();
            db.endTransaction();
        }).subscribeOn(Schedulers.io());
    }
}
