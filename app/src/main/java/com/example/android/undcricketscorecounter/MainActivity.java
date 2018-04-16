package com.example.android.undcricketscorecounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements Score {

    /* TextView for displaying total runs for Team A */
    @BindView(R.id.tv_team_a_score)
    TextView tvTeamAScore;

    /* TextView for displaying total wicket for Team A */
    @BindView(R.id.tv_team_a_wicket)
    TextView tvTeamAWicket;

    /* TextView for displaying total balls for Team A */
    @BindView(R.id.tv_team_a_ball)
    TextView tvTeamABall;

    /* TextView for displaying strike rate for Team A */
    @BindView(R.id.tv_team_a_strike_rate)
    TextView tvTeamAStrikeRate;

    /* TextView for displaying total runs for Team B */
    @BindView(R.id.tv_team_b_score)
    TextView tvTeamBScore;

    /* TextView for displaying total wicket for Team B */
    @BindView(R.id.tv_team_b_wicket)
    TextView tvTeamBWicket;

    /* TextView for displaying total balls for Team B */
    @BindView(R.id.tv_team_b_ball)
    TextView tvTeamBBall;

    /* TextView for displaying strike rate for Team B */
    @BindView(R.id.tv_team_b_strike_rate)
    TextView tvTeamBStrikeRate;

    ScorePresenter mScorePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mScorePresenter = new ScorePresenter(this);
    }

    // Update Team A performance matrix
    public void teamAOneRun(View v) {
        mScorePresenter.updateTeamAScore(1);
    }

    public void teamATwoRun(View v) {
        mScorePresenter.updateTeamAScore(2);
    }

    public void teamAThreeRun(View v) {
        mScorePresenter.updateTeamAScore(3);
    }

    public void teamAFourRun(View v) {
        mScorePresenter.updateTeamAScore(4);
    }

    public void teamASixRun(View v) {
        mScorePresenter.updateTeamAScore(6);
    }

    public void teamAOut(View v) {
        mScorePresenter.updateTeamAWicket();
    }

    public void teamABallCount(View v) {
        mScorePresenter.updateTeamABall();
    }

    // Update Team B performance matrix
    public void teamBOneRun(View v) {
        mScorePresenter.updateTeamBScore(1);
    }

    public void teamBTwoRun(View v) {
        mScorePresenter.updateTeamBScore(2);
    }

    public void teamBThreeRun(View v) {
        mScorePresenter.updateTeamBScore(3);
    }

    public void teamBFourRun(View v) {
        mScorePresenter.updateTeamBScore(4);
    }

    public void teamBSixRun(View v) {
        mScorePresenter.updateTeamBScore(5);
    }

    public void teamBOut(View v) {
        mScorePresenter.updateTeamBWicket();
    }

    public void teamBBallCount(View v) {
        mScorePresenter.updateTeamBBall();
    }

    // Update views
    @Override
    public void setTeamARun(int run) {
        tvTeamAScore.setText(String.valueOf(run));
    }

    @Override
    public void setTeamABall(int ball) {
        tvTeamABall.setText(String.valueOf(ball));
    }

    @Override
    public void setTeamAWicket(int wicket) {
        tvTeamAWicket.setText(String.valueOf(wicket));
    }

    @Override
    public void setTeamAStrikeRate(double strikeRate) {
        tvTeamAStrikeRate.setText(String.valueOf(strikeRate));
    }

    @Override
    public void setTeamBRun(int run) {
        tvTeamBScore.setText(String.valueOf(run));
    }

    @Override
    public void setTeamBBall(int ball) {
        tvTeamBBall.setText(String.valueOf(ball));
    }

    @Override
    public void setTeamBWicket(int wicket) {
        tvTeamBWicket.setText(String.valueOf(wicket));
    }

    @Override
    public void setTeamBStrikeRate(double strikeRate) {
        tvTeamBStrikeRate.setText(String.valueOf(strikeRate));
    }

    public void reset(View view) {
        // Team A
        tvTeamAScore.setText(String.valueOf(0));
        tvTeamABall.setText(String.valueOf(0));
        tvTeamAWicket.setText(String.valueOf(0));
        tvTeamAStrikeRate.setText(String.valueOf(0.0));
        //Team B
        tvTeamBScore.setText(String.valueOf(0));
        tvTeamBBall.setText(String.valueOf(0));
        tvTeamBWicket.setText(String.valueOf(0));
        tvTeamBStrikeRate.setText(String.valueOf(0.0));
        mScorePresenter.resetGame();
    }
}