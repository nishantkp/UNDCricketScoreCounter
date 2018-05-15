package com.example.android.undcricketscorecounter.ui.team;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.undcricketscorecounter.R;
import com.example.android.undcricketscorecounter.databinding.ActivityTeamSelectionBinding;

public class TeamSelectionActivity extends AppCompatActivity {

    private ActivityTeamSelectionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_team_selection);
    }
}
