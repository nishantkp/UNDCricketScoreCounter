package com.example.android.undcricketscorecounter.ui.team;

import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
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

    /**
     * Check for the stored preference value to show alert dialog
     */
    @Override
    protected void onResume() {
        super.onResume();
        presenter.restoreState();
    }

    /**
     * When team names are valid start {@link MainActivity}
     */
    @Override
    public void onSuccess() {
        startActivity(new Intent(TeamSelectionActivity.this, MainActivity.class));
    }

    /**
     * Display error message in case of invalid team names
     *
     * @param error error message
     */
    @Override
    public void onError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        //Snackbar.make(binding.coordinatorTeam, error, Snackbar.LENGTH_SHORT).show();
    }

    /**
     * If data is present in preferences, show alert dialog to start new game
     * OR load an existing one
     */
    @Override
    public void onRestoreGame() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.alertDialog)
                .setCancelable(false)
                .setTitle(R.string.load_dialog_title)
                .setPositiveButton(R.string.load_dialog_positive_button,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // start MainActivity
                                startActivity(new Intent(TeamSelectionActivity.this,
                                        MainActivity.class));
                                finish();
                            }
                        })
                .setNegativeButton(R.string.load_dialog_negative_button,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
        builder.show();
    }

    /**
     * onCLickHandler for start button
     *
     * @param view view
     */
    public void startGame(View view) {
        presenter.checkTeamDetails(binding.included.tvTeamAName.getText().toString().trim(),
                binding.included.tvTeamBName.getText().toString().trim());
    }
}