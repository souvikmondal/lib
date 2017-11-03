package com.tarento.android;

import com.tarento.android.net.ApiConnectionImpl;
import com.tarento.android.net.HttpClientBuilderImpl;
import com.tarento.android.net.HttpClientImpl;
import com.tarento.android.net.RetrofitClientImpl;
import com.tarento.android.net.def.ApiConnection;
import com.tarento.android.net.def.HttpClient;
import com.tarento.android.net.def.HttpClientBuilder;
import com.tarento.android.net.def.RetrofitClient;
import com.tarento.android.util.preferences.PreferenceStore;
import com.tarento.android.util.preferences.PreferenceStoreImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @Copyright www.tarento.com
 */
@Module
public class BaseStackModule {

    @Provides
    @Singleton
    HttpClient providesHttpClient(HttpClientImpl httpClient) {
        return httpClient;
    }

    @Provides
    @Singleton
    RetrofitClient providesRetrofitClient(RetrofitClientImpl retrofitClient) {
        return retrofitClient;
    }

    @Provides
    @Singleton
    HttpClientBuilder providesHttpClientBuilder(HttpClientBuilderImpl httpClientBuilder) {
        return httpClientBuilder;
    }

    @Provides
    @Singleton
    ApiConnection provideApiConnection(ApiConnectionImpl apiConnectionImpl) {
        return apiConnectionImpl;
    }

    @Provides
    @Singleton
    PreferenceStore providePrefStore(PreferenceStoreImpl preferenceStore) {
        return preferenceStore;
    }

}
