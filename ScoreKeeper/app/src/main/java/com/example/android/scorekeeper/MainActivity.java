package com.example.android.scorekeeper;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int foulTeamA = 0;
    int foulTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addSixForTeamA(View v) {
        scoreTeamA += 6;
        displayForTeamA(scoreTeamA);
    }

    public void addThreeForTeamA(View v) {
        scoreTeamA += 3;
        displayForTeamA(scoreTeamA);
    }

    public void addTwoForTeamA(View v) {
        scoreTeamA += 2;
        displayForTeamA(scoreTeamA);
    }

    public void addOneForTeamA(View v) {
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA);
    }

    public void addFoulForTeamA(View v) {
        foulTeamA += 1;
        displayFoulTeamA(foulTeamA);
    }

    public void addSixForTeamB(View v) {
        scoreTeamB += 6;
        displayForTeamB(scoreTeamB);
    }

    public void addThreeForTeamB(View v) {
        scoreTeamB += 3;
        displayForTeamB(scoreTeamB);
    }

    public void addTwoForTeamB(View v) {
        scoreTeamB += 2;
        displayForTeamB(scoreTeamB);
    }

    public void addOneForTeamB(View v) {
        scoreTeamB += 1;
        displayForTeamB(scoreTeamB);
    }

    public void addFoulForTeamB(View v) {
        foulTeamB += 1;
        displayFoulTeamB(foulTeamB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the foul for Team A.
     */
    public void displayFoulTeamA(int foul) {
        TextView foulView = (TextView) findViewById(R.id.team_a_fouls);
        foulView.setText(String.valueOf(foul));
    }

    /**
     * Displays the foul for Team B.
     */
    public void displayFoulTeamB(int foul) {
        TextView foulView = (TextView) findViewById(R.id.team_b_fouls);
        foulView.setText(String.valueOf(foul));
    }

    public void resetScore(View v) {
        if (scoreTeamA > scoreTeamB) {
            Context context = getApplicationContext();
            Toast.makeText(context, "Team A wins", Toast.LENGTH_SHORT).show();
        } else if (scoreTeamA < scoreTeamB) {
            Context context = getApplicationContext();
            Toast.makeText(context, "Team B wins", Toast.LENGTH_SHORT).show();
        } else if (scoreTeamA == scoreTeamB) {
            if (foulTeamA < foulTeamB) {
                Context context = getApplicationContext();
                Toast.makeText(context, "Team A wins", Toast.LENGTH_SHORT).show();
            } else if (foulTeamA > foulTeamB) {
                Context context = getApplicationContext();
                Toast.makeText(context, "Team B wins", Toast.LENGTH_SHORT).show();
            } else {
                Context context = getApplicationContext();
                Toast.makeText(context, "Draw!!", Toast.LENGTH_SHORT).show();
            }
        }
        scoreTeamA = 0;
        scoreTeamB = 0;
        foulTeamA = 0;
        foulTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayFoulTeamA(foulTeamA);
        displayFoulTeamB(foulTeamB);

        Context context = getApplicationContext();
        Toast.makeText(context, "Score Reset", Toast.LENGTH_SHORT).show();
    }
}

