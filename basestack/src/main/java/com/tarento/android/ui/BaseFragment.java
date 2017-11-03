package com.tarento.android.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tarento.android.presenter.Presenter;
import com.tarento.android.util.ui.KeyboardUtil;
import com.tarento.android.util.ui.ProgressUtil;
import com.tarento.android.ui.def.BaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseFragment extends Fragment implements BaseView{

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getFragmentLayoutId(), container, false);
        unbinder = ButterKnife.bind(getCurrentFragment(), view);
        hookInControlsToView(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getFragmentPresenter() != null) {
            getFragmentPresenter().onViewCreated(getCurrentFragment(), savedInstanceState);
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        if (getFragmentPresenter() != null) {
            getFragmentPresenter().onStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        if (getFragmentPresenter() != null) {
            getFragmentPresenter().onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        if (getFragmentPresenter() != null) {
            getFragmentPresenter().onPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();

        if (getFragmentPresenter() != null) {
            getFragmentPresenter().onStop();
        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (getFragmentPresenter() != null) {
            getFragmentPresenter().onSaveInstanceState(outState);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        unbinder.unbind();
        if (getFragmentPresenter() != null) {
            getFragmentPresenter().onDestroyView();
        }
    }

    @Override
    public void showLoader() {
        ProgressUtil.showLoader(getActivity());
    }

    @Override
    public void hideLoader() {
        ProgressUtil.hideLoader();
    }

    @Override
    public void showKeyboard(Context context, View forView) {
        KeyboardUtil.showKeyboard(context, forView);
    }

    @Override
    public void hideKeyboard() {
        KeyboardUtil.hideKeyboard(getActivity());
    }

    protected void hookInControlsToView(View view) {}

    protected abstract int getFragmentLayoutId();

    protected abstract <T extends BaseFragment & BaseView> T getCurrentFragment();

    protected abstract Presenter getFragmentPresenter();
}
