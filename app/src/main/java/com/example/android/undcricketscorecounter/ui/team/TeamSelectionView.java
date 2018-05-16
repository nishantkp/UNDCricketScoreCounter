package com.example.android.undcricketscorecounter.ui.team;

import com.example.android.undcricketscorecounter.base.MvpView;

public interface TeamSelectionView {
    interface View extends MvpView {
        void onSuccess();

        void onError(String error);
    }

    interface Presenter {
        void checkTeamDetails(String name1, String name2);
    }
}
