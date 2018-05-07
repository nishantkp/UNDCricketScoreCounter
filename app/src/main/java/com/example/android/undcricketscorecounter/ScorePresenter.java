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

package com.example.android.undcricketscorecounter;

import com.example.android.undcricketscorecounter.base.BasePresenter;
import com.example.android.undcricketscorecounter.model.DataManager;

import java.text.DecimalFormat;

public class ScorePresenter extends BasePresenter<ScoreContract.view>
        implements ScoreContract.Presenter {

    private static int teamARun = 0;
    private static int teamABall = 0;
    private static int teamAWicket = 0;

    private static int teamBRun = 0;
    private static int teamBBall = 0;
    private static int teamBWicket = 0;
    private DataManager manager;

    @Override
    public void attachView(ScoreContract.view view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    ScorePresenter(DataManager manager) {
        this.manager = manager;
    }

    // Calculate strike-rate
    @Override
    public double calculateStrikeRate(int runs, int balls) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        double strikeRate = (runs * 100.00) / balls;
        return Double.parseDouble(df.format(strikeRate));
    }

    // Reset the game performance matrix
    @Override
    public void resetGame() {
        teamABall = 0;
        teamARun = 0;
        teamAWicket = 0;
        teamBBall = 0;
        teamBRun = 0;
        teamBWicket = 0;
        getView().resetGame();
        manager.clearPref();
    }

    // Restore the score state
    public void restoreState() {
        teamARun = Integer.parseInt(manager.loadDataFromPref("TEAM A RUN"));
        getView().setTeamARun(teamARun);

        teamABall = Integer.parseInt(manager.loadDataFromPref("TEAM A BALL"));
        getView().setTeamABall(teamABall);

        teamAWicket = Integer.parseInt(manager.loadDataFromPref("TEAM A WICKET"));
        getView().setTeamAWicket(teamAWicket);

        getView().setTeamAStrikeRate(Double.parseDouble(manager.loadDataFromPref("TEAM A STRIKE RATE")));

        teamBRun = Integer.parseInt(manager.loadDataFromPref("TEAM B RUN"));
        getView().setTeamBRun(teamBRun);

        teamBBall = Integer.parseInt(manager.loadDataFromPref("TEAM B BALL"));
        getView().setTeamBBall(teamBBall);

        teamBWicket = Integer.parseInt(manager.loadDataFromPref("TEAM B WICKET"));
        getView().setTeamBWicket(teamBWicket);

        getView().setTeamBStrikeRate(Double.parseDouble(manager.loadDataFromPref("TEAM B STRIKE RATE")));
    }

    @Override
    public void calculateTeamARun(int run) {
        teamARun += run;
        manager.storeDataToPref("TEAM A RUN", String.valueOf(teamARun));
        getView().setTeamARun(teamARun);
    }

    @Override
    public void calculateTeamABall() {
        teamABall += 1;
        getView().setTeamABall(teamABall);
        manager.storeDataToPref("TEAM A BALL", String.valueOf(teamABall));
        manager.storeDataToPref("TEAM A STRIKE RATE",
                String.valueOf(teamABall > 0 ? this.calculateStrikeRate(teamARun, teamABall) : 0.0));
        this.calculateTeamAStrikeRate();
    }

    @Override
    public void calculateTeamAWicket() {
        teamAWicket += 1;
        manager.storeDataToPref("TEAM A WICKET", String.valueOf(teamAWicket));
        getView().setTeamAWicket(teamAWicket);
    }

    @Override
    public void calculateTeamAStrikeRate() {
        getView().setTeamAStrikeRate(teamABall > 0 ? this.calculateStrikeRate(teamARun, teamABall) : 0.0);
    }

    @Override
    public void calculateTeamBRun(int run) {
        teamBRun += run;
        manager.storeDataToPref("TEAM B RUN", String.valueOf(teamBRun));
        getView().setTeamBRun(teamBRun);
    }

    @Override
    public void calculateTeamBBall() {
        teamBBall += 1;
        getView().setTeamBBall(teamBBall);
        manager.storeDataToPref("TEAM B BALL", String.valueOf(teamBBall));
        manager.storeDataToPref("TEAM B STRIKE RATE",
                String.valueOf(teamBBall > 0 ? this.calculateStrikeRate(teamBRun, teamBBall) : 0.0));
        this.calculateTeamBStrikeRate();
    }

    @Override
    public void calculateTeamBWicket() {
        teamBWicket += 1;
        manager.storeDataToPref("TEAM B WICKET", String.valueOf(teamAWicket));
        getView().setTeamBWicket(teamBWicket);
    }

    @Override
    public void calculateTeamBStrikeRate() {
        getView().setTeamBStrikeRate(teamBBall > 0 ? this.calculateStrikeRate(teamBRun, teamBBall) : 0.0);
    }
}
