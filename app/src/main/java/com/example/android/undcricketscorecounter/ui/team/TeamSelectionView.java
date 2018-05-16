package com.example.android.undcricketscorecounter.ui.team;

import com.example.android.undcricketscorecounter.base.MvpView;

public interface TeamSelectionView {
    interface View extends MvpView {
        void onSuccess();

        void onError(String error);

        void onRestoreGame();
    }

    interface Presenter {
        void checkTeamDetails(String name1, String name2);

        void restoreState();
    }
}
