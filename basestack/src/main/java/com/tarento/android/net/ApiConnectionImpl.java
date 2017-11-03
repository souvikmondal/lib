package com.tarento.android.net;

import com.tarento.android.net.def.ApiConnection;
import com.tarento.android.net.def.NetConfig;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ApiConnectionImpl implements ApiConnection {

    private RetrofitClientImpl client;
    private NetConfig netConfig;

    @Inject
    public ApiConnectionImpl(RetrofitClientImpl client, NetConfig netConfig) {
        this.client = client;
        this.netConfig = netConfig;
    }

    @Override
    public <T> T getClient() {
        return this.client.getClient().create(this.netConfig.<T>getServiceInterface());
    }
}