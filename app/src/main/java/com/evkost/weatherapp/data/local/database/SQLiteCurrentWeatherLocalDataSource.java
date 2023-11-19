package com.evkost.weatherapp.data.local.database;

import com.evkost.weatherapp.data.local.CurrentWeatherLocalDataSource;
import com.evkost.weatherapp.data.local.database.dao.core.RxDao;
import com.evkost.weatherapp.data.local.database.dao.core.query.Query;
import com.evkost.weatherapp.data.local.database.table.CurrentWeatherTable;
import com.evkost.weatherapp.model.entity.CurrentWeatherEntity;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class SQLiteCurrentWeatherLocalDataSource implements CurrentWeatherLocalDataSource {
    private final RxDao<CurrentWeatherEntity> currentWeatherDao;

    @Inject
    public SQLiteCurrentWeatherLocalDataSource(RxDao<CurrentWeatherEntity>  currentWeatherDao) {
        this.currentWeatherDao = currentWeatherDao;
    }

    @Override
    public Single<Long> save(CurrentWeatherEntity entity) {
        return currentWeatherDao.insert(entity);
    }

    @Override
    public Flowable<CurrentWeatherEntity> observeByDate(String date) {
        Query query = Query.builder()
                .selection(CurrentWeatherTable.Columns.DATE + " = ?", date)
                .build();
        return currentWeatherDao.observe(query, entity -> entity.getDate().equals(date));
    }
}
