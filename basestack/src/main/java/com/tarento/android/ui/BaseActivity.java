package com.tarento.android.ui;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(getActivityId());
        unbinder = ButterKnife.bind(this);
        if (getFragmentToInflate() != null) {
            Fragment fragment = getSupportFragmentManager().findFragmentById(getFragmentContainerId());
            if (fragment == null) {
                addFragment(getFragmentContainerId(), getFragmentToInflate());
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    private void addFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }

    public void replaceFragment(int containerViewId, Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(containerViewId, fragment);
        if (addToBackStack) fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    protected abstract int getFragmentContainerId();

    protected abstract int getActivityId();

    protected abstract Fragment getFragmentToInflate();

}
