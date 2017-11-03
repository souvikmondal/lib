package com.tarento.android.net.def;

import okhttp3.OkHttpClient;

public interface HttpClientBuilder {

    OkHttpClient.Builder getOkHttpClientBuilder();
}
