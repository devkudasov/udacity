package com.example.devkudasov.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int teamAScore = 0;
    int teamBScore = 0;

    int teamATimeouts = 5;
    int teamBTimeouts = 5;

    int teamAThreePointShots = 0;
    int teamBThreePointShots = 0;

    int teamATwoPointShots = 0;
    int teamBTwoPointShots = 0;

    int teamAFreeThrowShots = 0;
    int teamBFreeThrowShots = 0;

    TextView teamAScoreView;
    TextView teamBScoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamAScoreView = findViewById(R.id.team_a_score);
        teamBScoreView = findViewById(R.id.team_b_score);
    }

    public void addThreePointsForTeamA(View view) {
        TextView threePointShotsView = findViewById(R.id.team_a_three_points);

        teamAScore += 3;
        teamAThreePointShots++;

        display(teamAScoreView, teamAScore);
        display(threePointShotsView, teamAThreePointShots + " Three-point shots");
    }

    public void addTwoPointsForTeamA(View view) {
        TextView twoPointShotsView = findViewById(R.id.team_a_two_points);

        teamAScore += 2;
        teamATwoPointShots++;

        display(teamAScoreView, teamAScore);
        display(twoPointShotsView, teamATwoPointShots + " Two-point shots");
    }

    public void addFreeThrowForTeamA(View view) {
        TextView freeThrowShotsView = findViewById(R.id.team_a_free_throw);

        teamAScore++;
        teamAFreeThrowShots++;

        display(teamAScoreView, teamAScore);
        display(freeThrowShotsView, teamAFreeThrowShots + " Free Throw shots");
    }

    public void getTimeoutForTeamA(View view) {
        TextView timeoutView = findViewById(R.id.team_a_timeout);

        if (teamATimeouts > 0) {
            teamATimeouts--;
        }

        display(timeoutView, teamATimeouts + " Timeouts");
    }

    public void addThreePointsForTeamB(View view) {
        TextView threePointShotsView = findViewById(R.id.team_b_three_points);

        teamBScore += 3;
        teamBThreePointShots++;

        display(teamBScoreView, teamBScore);
        display(threePointShotsView, teamBThreePointShots + " Three-point shots");
    }

    public void addTwoPointsForTeamB(View view) {
        TextView twoPointShotsView = findViewById(R.id.team_b_two_points);

        teamBScore += 2;
        teamBTwoPointShots++;

        display(teamBScoreView, teamBScore);
        display(twoPointShotsView, teamBTwoPointShots + " Two-point shots");
    }

    public void addFreeThrowForTeamB(View view) {
        TextView freeThrowShotsView = findViewById(R.id.team_b_free_throw);

        teamBScore++;
        teamBFreeThrowShots++;

        display(teamBScoreView, teamBScore);
        display(freeThrowShotsView, teamBFreeThrowShots + " Free Throw shots");
    }

    public void getTimeoutForTeamB(View view) {
        TextView timeoutView = findViewById(R.id.team_b_timeout);

        if (teamBTimeouts > 0) {
            teamBTimeouts--;
        }

        display(timeoutView, teamBTimeouts + " Timeouts");
    }

    public void resetScore(View view) {
        clearScores();
        clearTimeouts();
        clearThreePointShots();
        clearTwoPointShots();
        clearFreeThrowShots();
    }

    private void display(TextView view, String message) {
        view.setText(String.valueOf(message));
    }

    private void display(TextView view, int message) {
        view.setText(String.valueOf(message));
    }

    private void clearScores() {
        teamAScore = 0;
        teamBScore = 0;

        display(teamAScoreView, teamAScore);
        display(teamBScoreView, teamBScore);
    }

    private void clearTimeouts() {
        teamATimeouts = 5;
        teamBTimeouts = 5;

        TextView timeoutForTeamAView = findViewById(R.id.team_a_timeout);
        TextView timeoutForTeamBView = findViewById(R.id.team_b_timeout);

        display(timeoutForTeamAView, teamATimeouts + " Timeouts");
        display(timeoutForTeamBView, teamBTimeouts + " Timeouts");
    }

    private void clearThreePointShots() {
        teamAThreePointShots = 0;
        teamBThreePointShots = 0;

        TextView threePointShotsForTeamAView = findViewById(R.id.team_a_three_points);
        TextView threePointShotsForTeamBView = findViewById(R.id.team_b_three_points);

        display(threePointShotsForTeamAView, teamAThreePointShots + " Three-point shots");
        display(threePointShotsForTeamBView, teamBThreePointShots + " Three-point shots");
    }

    private void clearTwoPointShots() {
        teamATwoPointShots = 0;
        teamBTwoPointShots = 0;

        TextView twoPointShotsForTeamAView = findViewById(R.id.team_a_two_points);
        TextView twoPointShotsForTeamBView = findViewById(R.id.team_b_two_points);

        display(twoPointShotsForTeamAView, teamATwoPointShots + " Two-point shots");
        display(twoPointShotsForTeamBView, teamBTwoPointShots + " Two-point shots");
    }

    private void clearFreeThrowShots() {
        teamAFreeThrowShots = 0;
        teamBFreeThrowShots = 0;

        TextView freeThrowShotsForTeamAView = findViewById(R.id.team_a_free_throw);
        TextView freeThrowShotsForTeamBView = findViewById(R.id.team_b_free_throw);

        display(freeThrowShotsForTeamAView, teamAFreeThrowShots + " Free Throw Shots");
        display(freeThrowShotsForTeamBView, teamBFreeThrowShots + " Free Throw Shots");
    }
}
