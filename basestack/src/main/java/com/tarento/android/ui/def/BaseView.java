package com.tarento.android.ui.def;

import android.content.Context;
import android.view.View;

public interface BaseView {
    void showLoader();
    void hideLoader();
    void showKeyboard(Context context, View forView);
    void hideKeyboard();
}