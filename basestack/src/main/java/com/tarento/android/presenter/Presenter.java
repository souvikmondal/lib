package com.tarento.android.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.tarento.android.net.def.AbstractDataFetch;
import com.tarento.android.presenter.def.PresenterLifecycle;
import com.tarento.android.ui.def.BaseView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public abstract class Presenter<T extends BaseView> implements PresenterLifecycle {

    private CompositeDisposable compositeSubscription;
    private BaseView view;

    public void onViewCreated(@NonNull T view, @Nullable Bundle savedInstanceState) {
        this.view = view;
    }

    @Override
    public void onStart() {
        compositeSubscription = new CompositeDisposable();
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
    }

    @Override
    public void onStop() {
        compositeSubscription.clear();
    }

    @Override
    public void onDestroyView() {
        compositeSubscription.dispose();
        view = null;
    }

    public T getView() {
        return (T) view;
    }

    protected void setView(T view) {
        this.view = view;
    }


    public void addSubscription(Disposable subscription) {
        this.compositeSubscription.add(subscription);
    }

    protected <Request, Response> void asyncLoadData(AbstractDataFetch<Request, Response> dataFetch, Request request, DataListener<Response> dataListener) {
        this.addSubscription(dataFetch.fetch(request).subscribeWith(dataListener));
    }

    public abstract class DataListener<T> extends DisposableObserver<T> {

        @Override
        public final void onNext(@io.reactivex.annotations.NonNull T t) {
            onSuccess(t);
        }

        @Override
        public final void onError(@io.reactivex.annotations.NonNull Throwable e) {
            onFail(e);
        }

        @Override
        public void onComplete() {

        }

        protected abstract void onSuccess(@io.reactivex.annotations.NonNull T t);

        protected abstract void onFail(@io.reactivex.annotations.NonNull Throwable e);
    }

}