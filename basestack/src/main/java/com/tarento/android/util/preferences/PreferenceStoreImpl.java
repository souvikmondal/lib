package com.tarento.android.util.preferences;

import android.app.Application;
import android.content.SharedPreferences;

import javax.inject.Inject;

/**
 * @Copyright www.tarento.com
 */

public class PreferenceStoreImpl implements PreferenceStore {

    private PrefConfig prefConfig;
    private SharedPreferences sharedPreferences;

    @Inject
    public PreferenceStoreImpl(PrefConfig prefConfig, Application context) {
        this.prefConfig = prefConfig;
        this.sharedPreferences = context.getSharedPreferences(prefConfig.getPrefName(), prefConfig.getPrefMode());
    }

    @Override
    public <T> void put(String key, T value) {
        if (value instanceof String) {
            this.sharedPreferences.edit().putString(key, (String) value).apply();
        } else if (value instanceof Boolean) {
            this.sharedPreferences.edit().putBoolean(key, (Boolean) value).apply();
        } else if (value instanceof Integer) {
            this.sharedPreferences.edit().putInt(key, (Integer) value).apply();
        } else if (value instanceof Float) {
            this.sharedPreferences.edit().putFloat(key, (Float) value).apply();
        } else if (value instanceof Long) {
            this.sharedPreferences.edit().putLong(key, (Long) value).apply();
        }
    }

    @Override
    public SharedPreferences getSharedPreference() {
        return this.sharedPreferences;
    }


    public void clear() {
        this.sharedPreferences.edit().clear().apply();
    }

    public void clear(String key) {
        this.sharedPreferences.edit().remove(key).apply();
    }

}
