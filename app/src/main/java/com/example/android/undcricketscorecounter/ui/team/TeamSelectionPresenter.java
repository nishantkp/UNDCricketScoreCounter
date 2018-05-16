package com.example.android.undcricketscorecounter.ui.team;

import android.text.TextUtils;

import com.example.android.undcricketscorecounter.base.BasePresenter;
import com.example.android.undcricketscorecounter.model.DataManager;
import com.example.android.undcricketscorecounter.utils.IConstants;

public class TeamSelectionPresenter extends BasePresenter<TeamSelectionView.View>
        implements TeamSelectionView.Presenter {

    private DataManager manager;

    TeamSelectionPresenter(DataManager manager) {
        this.manager = manager;
    }

    @Override
    public void attachView(TeamSelectionView.View view) {
        super.attachView(view);
    }

    @Override
    public TeamSelectionView.View getView() {
        return super.getView();
    }

    /**
     * Check name of teams are valid or not?
     * If valid, store them into preferences otherwise setup callBack to show error message
     *
     * @param name1 name of Team A
     * @param name2 name of Team B
     */
    @Override
    public void checkTeamDetails(String name1, String name2) {
        if (!TextUtils.isEmpty(name1) && !TextUtils.isEmpty(name2)) {
            // Clear preference data before starting new game
            manager.clearPref();
            manager.storeStringToPref(IConstants.PreferenceKey.TEAM_A_NAME, name1);
            manager.storeStringToPref(IConstants.PreferenceKey.TEAM_B_NAME, name2);
            getView().onSuccess();
        } else {
            getView().onError("Provide valid team name!");
        }
    }

    /**
     * If data is available in preferences, set up a callback to show alert dialog
     * to start new game OR load existing game
     */
    @Override
    public void restoreState() {
        if (manager.isDataAvailableInPref(IConstants.PreferenceKey.TEAM_A_RUN)) {
            getView().onRestoreGame();
        }
    }
}
