package com.evkost.weatherapp.data.local.database.transaction;

import java.util.concurrent.Callable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;

public interface TransactionManager {
    <T> Single<T> transactionSingle(Callable<Single<T>> callable);

    <T> Flowable<T> transaction(Callable<Flowable<T>> callable);
}
