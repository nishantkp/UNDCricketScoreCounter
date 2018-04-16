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

import java.text.DecimalFormat;

public class ScorePresenter {
    private static int teamARun = 0;
    private static int teamABall = 0;
    private static int teamAWicket = 0;

    private static int teamBRun = 0;
    private static int teamBBall = 0;
    private static int teamBWicket = 0;
    private Score mScore;

    ScorePresenter(Score score) {
        mScore = score;
    }

    public void updateTeamAScore(int run) {
        teamARun += run;
        mScore.setTeamARun(teamARun);
    }

    public void updateTeamABall() {
        teamABall += 1;
        mScore.setTeamAStrikeRate(teamABall > 0 ? calculateStrikeRate(teamARun, teamABall) : 0.0);
        mScore.setTeamABall(teamABall);
    }

    public void updateTeamAWicket() {
        teamAWicket += 1;
        mScore.setTeamAWicket(teamAWicket);
    }

    public void updateTeamBScore(int run) {
        teamBRun += run;
        mScore.setTeamBRun(teamBRun);
    }

    public void updateTeamBBall() {
        teamBBall += 1;
        mScore.setTeamBStrikeRate(teamBBall > 0 ? calculateStrikeRate(teamBRun, teamBBall) : 0.0);
        mScore.setTeamBBall(teamBBall);
    }

    public void updateTeamBWicket() {
        teamBWicket += 1;
        mScore.setTeamBWicket(teamBWicket);
    }

    // Calculate strike-rate
    private double calculateStrikeRate(int runs, int balls) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        double strikeRate = (runs * 100.00) / balls;
        return Double.parseDouble(df.format(strikeRate));
    }

    // Reset the game performance matrix
    public void resetGame() {
        teamABall = 0;
        teamARun = 0;
        teamAWicket = 0;
        teamBBall = 0;
        teamBRun = 0;
        teamBWicket = 0;
    }
}
