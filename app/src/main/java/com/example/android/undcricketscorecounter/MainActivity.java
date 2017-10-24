package com.example.android.undcricketscorecounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    /* Total runs for Team A */
    int teamARuns = 0;
    /* Total balls for Team A */
    int teamABalls = 0;
    /* Total wicket for Team A */
    int teamAOut = 0;

    /* Total runs for Team B */
    int teamBRuns = 0;
    /* Total balls for Team B */
    int teamBBalls = 0;
    /* Total wicket for Team B */
    int teamBOut = 0;

    /* Average strike rate for Team A */
    double teamAStrikeRate = 0.0;

    /* Average strike rate for team B */
    double teamBStrikeRate = 0.0;

    /* TextView for displaying total runs for Team A */
    private TextView teamARunTextView;

    /* TextView for displaying total wicket for Team A */
    private TextView teamAWicketTextView;

    /* TextView for displaying total balls for Team A */
    private TextView teamABallCountTextView;

    /* TextView for displaying strike rate for Team A */
    private TextView teamAStrikeRateTextView;

    /* TextView for displaying total runs for Team B */
    private TextView teamBRunTextView;

    /* TextView for displaying total wicket for Team B */
    private TextView teamBWicketTextView;

    /* TextView for displaying total balls for Team B */
    private TextView teamBBallCountTextView;

    /* TextView for displaying strike rate for Team B */
    private TextView teamBStrikeRateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Find the TextView with their respective IDs */
        teamARunTextView = (TextView) findViewById(R.id.team_a_score);
        teamABallCountTextView = (TextView) findViewById(R.id.team_a_ball);
        teamAWicketTextView = (TextView) findViewById(R.id.team_a_wicket);
        teamAStrikeRateTextView = (TextView) findViewById(R.id.team_a_strike_rate);
        teamBRunTextView = (TextView) findViewById(R.id.team_b_score);
        teamBBallCountTextView = (TextView) findViewById(R.id.team_b_ball);
        teamBWicketTextView = (TextView) findViewById(R.id.team_b_wicket);
        teamBStrikeRateTextView = (TextView) findViewById(R.id.team_b_strike_rate);
    }

    /**
     * Increase runs by +1 for Team A
     */
    public void teamAOneRun(View v) {
        teamARuns += 1;
        displayForTeamA(teamARuns, 1);
    }

    /**
     * Increase runs by +2 for Team A
     */
    public void teamATwoRun(View v) {
        teamARuns += 2;
        displayForTeamA(teamARuns, 1);
    }

    /**
     * Increase runs by +3 for Team A
     */
    public void teamAThreeRun(View v) {
        teamARuns += 3;
        displayForTeamA(teamARuns, 1);
    }

    /**
     * Increase runs by +4 for Team A
     */
    public void teamAFourRun(View v) {
        teamARuns += 4;
        displayForTeamA(teamARuns, 1);
    }

    /**
     * Increase runs by +6 for Team A
     */
    public void teamASixRun(View v) {
        teamARuns += 6;
        displayForTeamA(teamARuns, 1);
    }

    /**
     * Increase out by +1 for Team A
     */
    public void teamAOut(View v) {
        teamAOut += 1;
        displayForTeamA(teamAOut, 2);
    }

    /**
     * Increase balls by +1 for Team A
     */
    public void teamABallCount(View v) {
        teamABalls += 1;
        displayForTeamA(teamABalls, 3);
    }


    /**
     * Increase runs by +1 for Team B
     */
    public void teamBOneRun(View v) {
        teamBRuns += 1;
        displayForTeamB(teamBRuns, 1);
    }

    /**
     * Increase runs by +2 for Team B
     */
    public void teamBTwoRun(View v) {
        teamBRuns += 2;
        displayForTeamB(teamBRuns, 1);
    }

    /**
     * Increase runs by +3 for Team B
     */
    public void teamBThreeRun(View v) {
        teamBRuns += 3;
        displayForTeamB(teamBRuns, 1);
    }

    /**
     * Increase runs by +4 for Team B
     */
    public void teamBFourRun(View v) {
        teamBRuns += 4;
        displayForTeamB(teamBRuns, 1);
    }

    /**
     * Increase runs by +6 for Team B
     */
    public void teamBSixRun(View v) {
        teamBRuns += 6;
        displayForTeamB(teamBRuns, 1);
    }

    /**
     * Increase out by +1 for Team B
     */
    public void teamBOut(View v) {
        teamBOut += 1;
        displayForTeamB(teamBOut, 2);
    }

    /**
     * Increase balls by +1 for Team B
     */
    public void teamBBallCount(View v) {
        teamBBalls += 1;
        displayForTeamB(teamBBalls, 3);
    }

    /**
     * Calculate Strike rate for Team A
     */
    public void teamAStrikeRate() {
        // Change decimal format to 2 for displaying
        // floating data with two decimal points
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        teamAStrikeRate = (teamARuns * 100.00) / teamABalls;
        teamAStrikeRateTextView.setText(String.valueOf(df.format(teamAStrikeRate)));
    }

    /**
     * Calculate Strike rate for Team B and change decimal format to 2
     */
    public void teamBStrikeRate() {
        // Change decimal format to 2 for displaying
        // floating data with two decimal points
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        teamBStrikeRate = (teamBRuns * 100.00) / teamBBalls;
        teamBStrikeRateTextView.setText(String.valueOf(df.format(teamBStrikeRate)));
    }

    /**
     * Reset everything
     */
    public void reset(View v) {
        teamARuns = 0;
        teamABalls = 0;
        teamAOut = 0;
        teamAStrikeRate = 0.0;
        teamBRuns = 0;
        teamBBalls = 0;
        teamBOut = 0;
        teamBStrikeRate = 0.0;
        /* Display reset values for Team A */
        teamARunTextView.setText(String.valueOf(teamARuns));
        teamABallCountTextView.setText(String.valueOf(teamABalls));
        teamAWicketTextView.setText(String.valueOf(teamAOut));
        teamAStrikeRateTextView.setText(String.valueOf(teamAStrikeRate));
        /* Display reset values for Team B */
        teamBRunTextView.setText(String.valueOf(teamBRuns));
        teamBBallCountTextView.setText(String.valueOf(teamBBalls));
        teamBWicketTextView.setText(String.valueOf(teamBOut));
        teamBStrikeRateTextView.setText(String.valueOf(teamBStrikeRate));
    }

    /**
     * Displays the given score for Team A.
     *
     * @param identifier = 1 : update team A runs
     *                   = 2 : update team A wicket
     *                   = 3 : update team A balls
     */
    public void displayForTeamA(int score, int identifier) {
        // Whenever number of balls is greater than zero, calculate the strike rate and display it.
        if (teamABalls > 0) {
            teamAStrikeRate();
        }
        switch (identifier) {
            case 1:
                teamARunTextView.setText(String.valueOf(score));
                break;
            case 2:
                teamAWicketTextView.setText(String.valueOf(score));
                break;
            case 3:
                teamABallCountTextView.setText(String.valueOf(score));
                break;
        }
    }

    /**
     * Displays the given score for Team B.
     *
     * @param identifier = 1 : update team A runs
     *                   = 2 : update team A wicket
     *                   = 3 : update team A balls
     */
    public void displayForTeamB(int score, int identifier) {
        // Whenever number of balls is greater than zero, calculate the strike rate and display it.
        if (teamBBalls > 0) {
            teamBStrikeRate();
        }
        switch (identifier) {
            case 1:
                teamBRunTextView.setText(String.valueOf(score));
                break;
            case 2:
                teamBWicketTextView.setText(String.valueOf(score));
                break;
            case 3:
                teamBBallCountTextView.setText(String.valueOf(score));
                break;
        }
    }
}
