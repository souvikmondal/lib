package com.tarento.android.util.preferences;

import android.content.SharedPreferences;

/**
 * @Copyright www.tarento.com
 */

public interface PreferenceStore {

    <T> void put(String key, T value);

    SharedPreferences getSharedPreference();
}
