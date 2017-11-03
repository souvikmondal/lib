package com.tarento.android.net.def;

/**
 * Created by Souvik Mondal on 11-10-2017.
 */

public interface NetConfig {

    String getBaseUrl();

    boolean isDebug();

    <T> Class<T> getServiceInterface();
}
