package com.tarento.android.net.def;

import com.tarento.android.net.ApiConnectionImpl;

import javax.inject.Inject;

import io.reactivex.Observable;


public abstract class AbstractDataFetch<Request, Response> {

    @Inject
    public ApiConnectionImpl api;

    public abstract Observable<Response> fetch(Request request);

}