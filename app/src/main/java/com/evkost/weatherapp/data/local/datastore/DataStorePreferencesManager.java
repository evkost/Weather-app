package com.evkost.weatherapp.data.local.datastore;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.rxjava3.RxDataStore;

import com.evkost.weatherapp.data.local.PreferencesManager;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class DataStorePreferencesManager implements PreferencesManager {
    private final Preferences.Key<String> SELECTED_REGION = PreferencesKeys.stringKey("selected_region");

    private final RxDataStore<Preferences> dataStore;

    @Inject
    public DataStorePreferencesManager(RxDataStore<Preferences> dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public Flowable<String> getSelectedRegionFlow() {
        return dataStore.data().map(prefs -> "London");
    }

    @Override
    public Completable setSelectedRegion(String region) {
        return Completable.fromSingle(
                dataStore.updateDataAsync(prefsIn -> {
                    MutablePreferences mutablePreferences = prefsIn.toMutablePreferences();
                    mutablePreferences.set(SELECTED_REGION, region);
                    return Single.just(mutablePreferences);
                })
        );
    }
}
