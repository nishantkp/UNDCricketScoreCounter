package com.example.android.undcricketscorecounter.ui.team;

import android.provider.ContactsContract;
import android.text.TextUtils;

import com.example.android.undcricketscorecounter.base.BasePresenter;
import com.example.android.undcricketscorecounter.model.DataManager;

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

    @Override
    public void checkTeamDetails(String name1, String name2) {
        if (!TextUtils.isEmpty(name1) && !TextUtils.isEmpty(name2)) {
            manager.storeStringToPref("TEAM_A_NAME", name1);
            manager.storeStringToPref("TEAM_B_NAME", name2);
            getView().onSuccess();
        } else {
            getView().onError("Provide valid team name!");
        }
    }
}
