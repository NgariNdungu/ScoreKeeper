package com.createchs.scorekeeper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    private int scoreTeamA;
    private int scoreTeamB;
    private static final String TEAM_A = "scoreTeamA";
    private static final String TEAM_B = "scoreTeamB";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTeamA = scoreTeamB = 0;
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


    public void resetScores(View view) {
        scoreTeamA = scoreTeamB = 0;
        display();
    }

    private void display() {
        TextView teamAScore = (TextView) findViewById(R.id.score_team_a);
        TextView teamBScore = (TextView) findViewById(R.id.score_team_b);

        teamAScore.setText(String.valueOf(scoreTeamA));
        teamBScore.setText(String.valueOf(scoreTeamB));
    }

    public void addTry(View view) {
        addScore(view,5);
        display();
    }

    private void addScore(View view, int score) {
        if (view.getParent() == findViewById(R.id.interactives_team_a)) {
            scoreTeamA += score;
        } else {
            scoreTeamB += score;
        }
    }

    public void addConvertedTry(View view) {
        addScore(view,7);
        display();
    }

    public void addPenalty(View view) {
        addScore(view,3);
        display();
    }
}
