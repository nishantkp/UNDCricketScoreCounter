package com.example.android.undcricketscorecounter;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.text.DecimalFormat;

import static com.example.android.undcricketscorecounter.BR.*;

public class ScoreMatrix extends BaseObservable {

    /* Team A performance matrix */
    private int teamARun = 0;
    private int teamABall = 0;
    private int teamAWicket = 0;
    private double teamASr = 0.0;
    private boolean teamAScoreButtonStatus = true;

    /* Team B performance matrix */
    private int teamBRun = 0;
    private int teamBBall = 0;
    private int teamBWicket = 0;
    private double teamBSr = 0.0;
    private boolean teamBScoreButtonStatus = true;

    public void setTeamARun(int run) {
        teamARun += run;
        teamAScoreButtonStatus = false;
        notifyPropertyChanged(_all);
    }

    public void setTeamABall(int ball) {
        teamABall += ball;
        teamASr = teamABall > 0 ? calculateStrikeRate(teamARun, teamABall) : 0.0;
        teamAScoreButtonStatus = true;
        notifyPropertyChanged(_all);
    }

    public void setTeamAWicket(int wicket) {
        teamAWicket += wicket;
        notifyPropertyChanged(_all);
    }

    public void setTeamBRun(int run) {
        teamBRun += run;
        teamBScoreButtonStatus = false;
        notifyPropertyChanged(_all);
    }

    public void setTeamBBall(int ball) {
        teamBBall += ball;
        teamBSr = teamBBall > 0 ? calculateStrikeRate(teamBRun, teamBBall) : 0.0;
        teamBScoreButtonStatus = true;
        notifyPropertyChanged(_all);
    }

    public void setTeamBWicket(int wicket) {
        teamBWicket += wicket;
        notifyPropertyChanged(_all);
    }

    @Bindable
    public int getTeamARun() {
        return teamARun;
    }

    @Bindable
    public int getTeamABall() {
        return teamABall;
    }

    @Bindable
    public int getTeamAWicket() {
        return teamAWicket;
    }

    @Bindable
    public double getTeamASr() {
        return teamASr;
    }

    @Bindable
    public boolean isTeamAScoreButtonStatus() {
        return teamAScoreButtonStatus;
    }

    @Bindable
    public int getTeamBRun() {
        return teamBRun;
    }

    @Bindable
    public int getTeamBBall() {
        return teamBBall;
    }

    @Bindable
    public int getTeamBWicket() {
        return teamBWicket;
    }

    @Bindable
    public double getTeamBSr() {
        return teamBSr;
    }

    @Bindable
    public boolean isTeamBScoreButtonStatus() {
        return teamBScoreButtonStatus;
    }

    private double calculateStrikeRate(int runs, int balls) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        double strikeRate = (runs * 100.00) / balls;
        return Double.parseDouble(df.format(strikeRate));
    }

    public void resetGame() {
        teamARun = 0;
        teamABall = 0;
        teamAWicket = 0;
        teamASr = 0;
        teamBRun = 0;
        teamBBall = 0;
        teamBWicket = 0;
        teamBSr = 0;
    }
}
