/*
 * The following license applies and this license notice
 * must be included in all works derived from this project.
 *
 * Copyright (c) 2017 Nishant Patel
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * Last modified 4/15/18 8:41 PM
 */

package com.example.android.undcricketscorecounter.ui.score;

import com.example.android.undcricketscorecounter.base.BasePresenter;
import com.example.android.undcricketscorecounter.model.DataManager;
import com.example.android.undcricketscorecounter.ui.model.ScoreMatrix;
import com.example.android.undcricketscorecounter.utils.IConstants;

public class ScorePresenter extends BasePresenter<ScoreContract.view>
        implements ScoreContract.Presenter {

    private ScoreMatrix matrix;
    private DataManager manager;

    @Override
    public void attachView(ScoreContract.view view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    ScorePresenter(ScoreMatrix matrix, DataManager manager) {
        this.matrix = matrix;
        this.manager = manager;
    }

    // Reset the game performance matrix
    @Override
    public void resetGame() {
        matrix.resetGame();
        getView().viewPerformanceMatrix(matrix);
        manager.clearPref();
    }

    @Override
    public void saveState() {
        manager.storeDataToPref(IConstants.PreferenceKey.TEAM_A_RUN, matrix.getTeamARun());
        manager.storeDataToPref(IConstants.PreferenceKey.TEAM_A_BALL, matrix.getTeamABall());
        manager.storeDataToPref(IConstants.PreferenceKey.TEAM_A_WICKET, matrix.getTeamAWicket());
        manager.storeDataToPref(IConstants.PreferenceKey.TEAM_B_RUN, matrix.getTeamBRun());
        manager.storeDataToPref(IConstants.PreferenceKey.TEAM_B_BALL, matrix.getTeamBBall());
        manager.storeDataToPref(IConstants.PreferenceKey.TEAM_B_WICKET, matrix.getTeamBWicket());
    }

    // Restore the score state
    public void restoreState() {
        // If data is not available in preference
        if (!manager.isDataAvailableInPref(IConstants.PreferenceKey.TEAM_A_RUN)) {
            return;
        }
        matrix.setTeamARun(manager.loadDataFromPref(IConstants.PreferenceKey.TEAM_A_RUN));
        matrix.setTeamABall(manager.loadDataFromPref(IConstants.PreferenceKey.TEAM_A_BALL));
        matrix.setTeamAWicket(manager.loadDataFromPref(IConstants.PreferenceKey.TEAM_A_WICKET));

        matrix.setTeamBRun(manager.loadDataFromPref(IConstants.PreferenceKey.TEAM_B_RUN));
        matrix.setTeamBBall(manager.loadDataFromPref(IConstants.PreferenceKey.TEAM_B_BALL));
        matrix.setTeamBWicket(manager.loadDataFromPref(IConstants.PreferenceKey.TEAM_B_WICKET));
        getView().loadSavedData(matrix);
    }

    @Override
    public void calculateTeamARun(int run) {
        matrix.setTeamARun(run);
        getView().viewPerformanceMatrix(matrix);
    }

    @Override
    public void calculateTeamABall() {
        matrix.setTeamABall(1);
        getView().viewPerformanceMatrix(matrix);
    }

    @Override
    public void calculateTeamAWicket() {
        matrix.setTeamAWicket(1);
        getView().viewPerformanceMatrix(matrix);
    }

    @Override
    public void calculateTeamBRun(int run) {
        matrix.setTeamBRun(run);
        getView().viewPerformanceMatrix(matrix);
    }

    @Override
    public void calculateTeamBBall() {
        matrix.setTeamBBall(1);
        getView().viewPerformanceMatrix(matrix);
    }

    @Override
    public void calculateTeamBWicket() {
        matrix.setTeamBWicket(1);
        getView().viewPerformanceMatrix(matrix);
    }
}
