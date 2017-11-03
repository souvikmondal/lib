package com.tarento.android.util.ui;


import android.app.ProgressDialog;
import android.content.Context;

import com.tarento.android.R;

public class ProgressUtil {

    private static ProgressDialog progress;

    public static void showLoader(Context context) {
        hideLoader();
        progress = new ProgressDialog(context, R.style.DialogTheme);
        progress.setCancelable(false);
        progress.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
        progress.show();
    }

    public static void hideLoader() {
        if (progress != null && progress.isShowing())
            progress.dismiss();
    }

}
