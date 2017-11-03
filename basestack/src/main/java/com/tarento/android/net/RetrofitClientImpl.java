package com.tarento.android.net;


import com.tarento.android.net.def.NetConfig;
import com.tarento.android.net.def.RetrofitClient;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
public class RetrofitClientImpl implements RetrofitClient{

    HttpClientImpl httpClientImpl;
    NetConfig appConfig;

    @Inject
    public RetrofitClientImpl(HttpClientImpl httpClientImpl, NetConfig appConfig) {
        this.httpClientImpl = httpClientImpl;
        this.appConfig = appConfig;
    }

    @Override
    public Retrofit getClient() {
        return buildClient().client(this.httpClientImpl.getHttpClient()).build();
    }


    private Retrofit.Builder buildClient() {
        return new Retrofit.Builder().baseUrl(this.appConfig.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

    }

}