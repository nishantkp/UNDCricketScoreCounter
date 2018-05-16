package com.example.android.undcricketscorecounter.ui.team;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.android.undcricketscorecounter.R;
import com.example.android.undcricketscorecounter.databinding.ActivityTeamSelectionBinding;
import com.example.android.undcricketscorecounter.model.DataManager;
import com.example.android.undcricketscorecounter.ui.score.MainActivity;

public class TeamSelectionActivity extends AppCompatActivity
        implements TeamSelectionView.View {

    private ActivityTeamSelectionBinding binding;
    private TeamSelectionPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_team_selection);
        presenter = new TeamSelectionPresenter(DataManager.getInstance(this));
        presenter.attachView(this);
    }

    @Override
    public void onSuccess() {
        startActivity(new Intent(TeamSelectionActivity.this, MainActivity.class));
    }

    @Override
    public void onError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        //Snackbar.make(binding.coordinatorTeam, error, Snackbar.LENGTH_SHORT).show();
    }

    public void startGame(View view) {
        presenter.checkTeamDetails(binding.included.tvTeamAName.getText().toString().trim(),
                binding.included.tvTeamBName.getText().toString().trim());
    }
}