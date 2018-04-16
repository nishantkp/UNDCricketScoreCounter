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
