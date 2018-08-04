package com.createchs.scorekeeper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private int scoreTeamA;
    private int scoreTeamB;
    // constants for storing state
    private static final String TEAM_A = "scoreTeamA";
    private static final String TEAM_B = "scoreTeamB";
    // Team A button ids
    private ArrayList<Integer> teamAButtons = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTeamA = scoreTeamB = 0;
        // populate teamAButtons
        teamAButtons.add(R.id.try_team_a);
        teamAButtons.add(R.id.converted_team_a);
        teamAButtons.add(R.id.penalty_team_a);
    }

    /*
     * Restore the scores
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // set scores and update views
        scoreTeamA = savedInstanceState.getInt(TEAM_A);
        scoreTeamB = savedInstanceState.getInt(TEAM_B);
        display();
    }

    /*
     * Save current scores
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // save the current score for each team
        outState.putInt(TEAM_A, scoreTeamA);
        outState.putInt(TEAM_B, scoreTeamB);

        super.onSaveInstanceState(outState);
    }

    /*
    * reset score for both teams to zero and update the displayed scores
    */
    public void resetScores(View view) {
        scoreTeamA = scoreTeamB = 0;
        display();
    }

    /*
    * Update displayed scores
    */
    private void display() {
        TextView teamAScore = (TextView) findViewById(R.id.score_team_a);
        TextView teamBScore = (TextView) findViewById(R.id.score_team_b);

        teamAScore.setText(String.valueOf(scoreTeamA));
        teamBScore.setText(String.valueOf(scoreTeamB));
    }

    /*
    * Add to the current score
    */
    private void addScore(View view, int score) {
        if (teamAButtons.contains(view.getId())) {
            scoreTeamA += score;
        } else {
            scoreTeamB += score;
        }
    }

    public void addTry(View view) {
        // 5 points for a try
        addScore(view,5);
        display();
    }

    public void addConvertedTry(View view) {
        // 7 points for a try + conversion
        addScore(view,7);
        display();
    }

    public void addPenalty(View view) {
        // 3 points for a penalty
        addScore(view,3);
        display();
    }
}
