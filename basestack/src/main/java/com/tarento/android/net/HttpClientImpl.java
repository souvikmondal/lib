package com.tarento.android.net;

import com.tarento.android.net.def.HttpClient;
import com.tarento.android.net.def.HttpClientBuilder;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@Singleton
public class HttpClientImpl implements HttpClient {

    HttpClientBuilder builder;

    @Inject
    public HttpClientImpl(HttpClientBuilder builder) {
        this.builder = builder;
    }

    @Override
    public OkHttpClient getHttpClient() {
        return builder.getOkHttpClientBuilder()
                .addInterceptor(new HttpLoggingInterceptor())
                .build();
    }
}