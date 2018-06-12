package com.createchs.scorekeeper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
//    View teamAParentView = findViewById(R.id.interactives_team_a);
//    View teamBParentView = findViewById(R.id.interactives_team_b);
// These views are undefined at application start. App won't start


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
