package com.tarento.android.net;


import com.tarento.android.net.def.HttpClientBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;

@Singleton
public class HttpClientBuilderImpl implements HttpClientBuilder {

    @Inject
    public HttpClientBuilderImpl() {
    }

    @Override
    public OkHttpClient.Builder getOkHttpClientBuilder() {
        return new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS);
    }
}
