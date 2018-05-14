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

    private ScoreMatrix matrix;

    @Override
    public void attachView(ScoreContract.view view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    ScorePresenter(ScoreMatrix matrix) {
        this.matrix = matrix;
    }

    // Reset the game performance matrix
    @Override
    public void resetGame() {
        matrix.resetGame();
        getView().viewPerformanceMatrix(matrix);
    }

    // Restore the score state
//    public void restoreState() {
//        teamARun = Integer.parseInt(manager.loadDataFromPref("TEAM A RUN"));
//        getView().setTeamARun(teamARun);
//
//        teamABall = Integer.parseInt(manager.loadDataFromPref("TEAM A BALL"));
//        getView().setTeamABall(teamABall);
//
//        teamAWicket = Integer.parseInt(manager.loadDataFromPref("TEAM A WICKET"));
//        getView().setTeamAWicket(teamAWicket);
//
//        getView().setTeamAStrikeRate(Double.parseDouble(manager.loadDataFromPref("TEAM A STRIKE RATE")));
//
//        teamBRun = Integer.parseInt(manager.loadDataFromPref("TEAM B RUN"));
//        getView().setTeamBRun(teamBRun);
//
//        teamBBall = Integer.parseInt(manager.loadDataFromPref("TEAM B BALL"));
//        getView().setTeamBBall(teamBBall);
//
//        teamBWicket = Integer.parseInt(manager.loadDataFromPref("TEAM B WICKET"));
//        getView().setTeamBWicket(teamBWicket);
//
//        getView().setTeamBStrikeRate(Double.parseDouble(manager.loadDataFromPref("TEAM B STRIKE RATE")));
//    }

    @Override
    public void calculateTeamARun(int run) {
        matrix.setTeamARun(run);
        getView().viewPerformanceMatrix(matrix);
    }

    @Override
    public void calculateTeamABall() {
        matrix.setTeamABall();
        getView().viewPerformanceMatrix(matrix);
    }

    @Override
    public void calculateTeamAWicket() {
        matrix.setTeamAWicket();
        getView().viewPerformanceMatrix(matrix);
    }

    @Override
    public void calculateTeamBRun(int run) {
        matrix.setTeamBRun(run);
        getView().viewPerformanceMatrix(matrix);
    }

    @Override
    public void calculateTeamBBall() {
        matrix.setTeamBBall();
        getView().viewPerformanceMatrix(matrix);
    }

    @Override
    public void calculateTeamBWicket() {
        matrix.setTeamBWicket();
        getView().viewPerformanceMatrix(matrix);
    }
}
