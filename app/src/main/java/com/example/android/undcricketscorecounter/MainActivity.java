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
 * Last modified 4/15/18 8:39 PM
 */

package com.example.android.undcricketscorecounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
        implements Score {

    /* Team A TextViews */
    @BindView(R.id.tv_team_a_score)
    TextView tvTeamAScore;

    @BindView(R.id.tv_team_a_wicket)
    TextView tvTeamAWicket;

    @BindView(R.id.tv_team_a_ball)
    TextView tvTeamABall;

    @BindView(R.id.tv_team_a_strike_rate)
    TextView tvTeamAStrikeRate;

    /* Team B TextViews */
    @BindView(R.id.tv_team_b_score)
    TextView tvTeamBScore;

    @BindView(R.id.tv_team_b_wicket)
    TextView tvTeamBWicket;

    @BindView(R.id.tv_team_b_ball)
    TextView tvTeamBBall;

    @BindView(R.id.tv_team_b_strike_rate)
    TextView tvTeamBStrikeRate;

    ScorePresenter mScorePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mScorePresenter = new ScorePresenter(this, this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mScorePresenter.restoreState();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mScorePresenter.restoreState();
    }

    // Update Team A performance matrix
    @OnClick(R.id.btn_team_a_one_run)
    public void BtnTeamAOneRun() {
        mScorePresenter.updateTeamAScore(1);
    }

    @OnClick(R.id.btn_team_a_two_run)
    public void btnTeamATwoRun() {
        mScorePresenter.updateTeamAScore(2);
    }

    @OnClick(R.id.btn_team_a_three_run)
    public void btnTeamAThreeRun() {
        mScorePresenter.updateTeamAScore(3);
    }

    @OnClick(R.id.btn_team_a_four_run)
    public void btnTeamAFourRun() {
        mScorePresenter.updateTeamAScore(4);
    }

    @OnClick(R.id.btn_team_a_six_run)
    public void btnTeamASixRun() {
        mScorePresenter.updateTeamAScore(6);
    }

    @OnClick(R.id.btn_team_a_out)
    public void btnTeamAOut() {
        mScorePresenter.updateTeamAWicket();
    }

    @OnClick(R.id.btn_team_a_ball)
    public void btnTeamABall() {
        mScorePresenter.updateTeamABall();
    }

    // Update Team B performance matrix
    @OnClick(R.id.btn_team_b_one_run)
    public void btnTeamBOneRun() {
        mScorePresenter.updateTeamBScore(1);
    }

    @OnClick(R.id.btn_team_b_two_run)
    public void btnTeamBTwoRun() {
        mScorePresenter.updateTeamBScore(2);
    }

    @OnClick(R.id.btn_team_b_three_run)
    public void btnTeamBThreeRun() {
        mScorePresenter.updateTeamBScore(3);
    }

    @OnClick(R.id.btn_team_b_four_run)
    public void btnTeamBFourRun() {
        mScorePresenter.updateTeamBScore(4);
    }

    @OnClick(R.id.btn_team_b_six_run)
    public void btnTeamBSixRun() {
        mScorePresenter.updateTeamBScore(5);
    }

    @OnClick(R.id.btn_team_b_out)
    public void btnTeamBOut() {
        mScorePresenter.updateTeamBWicket();
    }

    @OnClick(R.id.btn_team_b_ball)
    public void btnTeamBBall() {
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

    @OnClick(R.id.btn_reset)
    public void btnReset() {
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