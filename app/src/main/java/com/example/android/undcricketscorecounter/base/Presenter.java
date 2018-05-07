package com.example.android.undcricketscorecounter.base;

public interface Presenter<T extends MvpView> {
    void attachView(T view);

    void detachView();
}
