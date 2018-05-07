package com.example.android.undcricketscorecounter.base;

import android.app.PendingIntent;

public class BasePresenter<T extends MvpView> implements Presenter<T> {

    private T view;

    @Override
    public void attachView(T view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    public boolean isViewAvailable() {
        return view != null;
    }

    public T getView() {
        return view;
    }
}
