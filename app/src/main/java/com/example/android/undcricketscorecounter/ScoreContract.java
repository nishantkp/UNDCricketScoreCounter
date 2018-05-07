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
 * Last modified 4/15/18 8:59 PM
 */

package com.example.android.undcricketscorecounter;

import com.example.android.undcricketscorecounter.base.MvpView;

public interface ScoreContract {
    interface view extends MvpView {
        void setTeamARun(int run);

        void setTeamABall(int ball);

        void setTeamAWicket(int wicket);

        void setTeamAStrikeRate(double strikeRate);

        void setTeamBRun(int run);

        void setTeamBBall(int ball);

        void setTeamBWicket(int wicket);

        void setTeamBStrikeRate(double strikeRate);

        void resetGame();
    }

    interface Presenter {
        void calculateTeamARun(int run);

        void calculateTeamABall();

        void calculateTeamAWicket();

        void calculateTeamAStrikeRate();

        void calculateTeamBRun(int run);

        void calculateTeamBBall();

        void calculateTeamBWicket();

        void calculateTeamBStrikeRate();

        void resetGame();

        double calculateStrikeRate(int runs, int balls);
    }
}
