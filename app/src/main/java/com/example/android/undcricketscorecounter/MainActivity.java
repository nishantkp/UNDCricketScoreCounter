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

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.undcricketscorecounter.databinding.ActivityMainBinding;
import com.example.android.undcricketscorecounter.model.DataManager;

public class MainActivity extends AppCompatActivity
        implements ScoreContract.view {
    private ActivityMainBinding binding;
    private ScorePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        DataManager dataManager = DataManager.getInstance(this);
        presenter = new ScorePresenter(dataManager);
        presenter.attachView(this);
        binding.setPresenter(presenter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.restoreState();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.restoreState();
    }

    // Update views
    @Override
    public void setTeamARun(int run) {
        binding.tvTeamAScore.setText(String.valueOf(run));
    }

    @Override
    public void setTeamABall(int ball) {
        binding.tvTeamABall.setText(String.valueOf(ball));
    }

    @Override
    public void setTeamAWicket(int wicket) {
        binding.tvTeamAWicket.setText(String.valueOf(wicket));
    }

    @Override
    public void setTeamAStrikeRate(double strikeRate) {
        binding.tvTeamAStrikeRate.setText(String.valueOf(strikeRate));
    }

    @Override
    public void disableTeamARunButtons() {
        binding.btnTeamAOneRun.setEnabled(false);
        binding.btnTeamATwoRun.setEnabled(false);
        binding.btnTeamAThreeRun.setEnabled(false);
        binding.btnTeamAFourRun.setEnabled(false);
        binding.btnTeamASixRun.setEnabled(false);
    }

    @Override
    public void enableTeamARunButtons() {
        binding.btnTeamAOneRun.setEnabled(true);
        binding.btnTeamATwoRun.setEnabled(true);
        binding.btnTeamAThreeRun.setEnabled(true);
        binding.btnTeamAFourRun.setEnabled(true);
        binding.btnTeamASixRun.setEnabled(true);
    }

    @Override
    public void setTeamBRun(int run) {
        binding.tvTeamBScore.setText(String.valueOf(run));
    }

    @Override
    public void setTeamBBall(int ball) {
        binding.tvTeamBBall.setText(String.valueOf(ball));
    }

    @Override
    public void setTeamBWicket(int wicket) {
        binding.tvTeamBWicket.setText(String.valueOf(wicket));
    }

    @Override
    public void setTeamBStrikeRate(double strikeRate) {
        binding.tvTeamBStrikeRate.setText(String.valueOf(strikeRate));
    }

    @Override
    public void disableTeamBRunButtons() {
        binding.btnTeamBOneRun.setEnabled(false);
        binding.btnTeamBTwoRun.setEnabled(false);
        binding.btnTeamBThreeRun.setEnabled(false);
        binding.btnTeamBFourRun.setEnabled(false);
        binding.btnTeamBSixRun.setEnabled(false);
    }

    @Override
    public void enableTeamBBunButtons() {
        binding.btnTeamBOneRun.setEnabled(true);
        binding.btnTeamBTwoRun.setEnabled(true);
        binding.btnTeamBThreeRun.setEnabled(true);
        binding.btnTeamBFourRun.setEnabled(true);
        binding.btnTeamBSixRun.setEnabled(true);
    }

    @Override
    public void resetGame() {
        binding.tvTeamABall.setText("0");
        binding.tvTeamAScore.setText("0");
        binding.tvTeamAWicket.setText("0");
        binding.tvTeamAStrikeRate.setText("0.0");
        binding.tvTeamBBall.setText("0");
        binding.tvTeamBWicket.setText("0");
        binding.tvTeamBScore.setText("0");
        binding.tvTeamBStrikeRate.setText("0.0");
    }
}