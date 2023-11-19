package com.evkost.weatherapp.data.local.database;

import com.evkost.weatherapp.data.local.ForecastDayLocalDataSource;
import com.evkost.weatherapp.data.local.database.transaction.TransactionManager;
import com.evkost.weatherapp.data.local.database.dao.core.RxDao;
import com.evkost.weatherapp.data.local.database.dao.core.query.Query;
import com.evkost.weatherapp.data.local.database.table.ForecastDayTable;
import com.evkost.weatherapp.data.local.database.table.ForecastHourTable;
import com.evkost.weatherapp.model.entity.ForecastDayEntity;
import com.evkost.weatherapp.model.entity.ForecastHourEntity;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class SQLiteForecastDayLocalDataSource implements ForecastDayLocalDataSource {
    private final RxDao<ForecastDayEntity> forecastDayEntityDao;
    private final RxDao<ForecastHourEntity> forecastHourEntityDao;
    private final TransactionManager transactionManager;

    @Inject
    public SQLiteForecastDayLocalDataSource(
            RxDao<ForecastDayEntity> forecastDayEntityDao,
            RxDao<ForecastHourEntity> forecastHourEntityDao,
            TransactionManager transactionManager) {
        this.forecastDayEntityDao = forecastDayEntityDao;
        this.forecastHourEntityDao = forecastHourEntityDao;
        this.transactionManager = transactionManager;
    }

    @Override
    public Single<Long> save(ForecastDayEntity entity) {
        return transactionManager.transactionSingle(() -> {
            Single<Long> dayIdSingle = forecastDayEntityDao.insert(entity);
            Single<List<Long>> hoursIdsSingle = forecastHourEntityDao.insertAll(entity.getForecastHours());

            return Single.zip(dayIdSingle, hoursIdsSingle, (dayId, hoursIds) -> dayId)
                    .flatMap(Single::just);
        });
    }

    @Override
    public Flowable<ForecastDayEntity> observeByDate(String date) {
        Query dayQuery = Query.builder()
                .selection(ForecastDayTable.Columns.DATE + " = ?", date)
                .build();

        return forecastDayEntityDao.observableQuery(
                entity -> entity.getDate().equals(date),
                () -> transactionManager.transaction(() ->
                        forecastDayEntityDao
                                .find(dayQuery)
                                .flatMap(this::fetchDayHours)
                                .toFlowable()
                )
        );
    }

    private Maybe<ForecastDayEntity> fetchDayHours(ForecastDayEntity entity) {
        Query dayHoursQuery = Query.builder()
                .selection(ForecastHourTable.Columns.FORECAST_DAY_ID + " = ?", entity.getId())
                .build();

        return forecastHourEntityDao
                .findAll(dayHoursQuery)
                .map(hoursList -> {
                    entity.setForecastHours(hoursList);
                    return entity;
                }).toMaybe();
    }
}
