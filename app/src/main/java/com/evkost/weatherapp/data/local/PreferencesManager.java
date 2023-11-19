package com.evkost.weatherapp.data.local;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

public interface PreferencesManager {
    Flowable<String> getSelectedRegionFlow();

    Completable setSelectedRegion(String region);
}
