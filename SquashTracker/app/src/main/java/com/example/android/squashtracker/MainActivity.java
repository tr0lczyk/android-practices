package com.example.android.squashtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreA = 0;
    int scoreB = 0;
    int setA = 0;
    int setB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * SCORES!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     */

    /**
     * adds one point to the player A score
     */
    public void addOnePointA(View view){
        scoreA = scoreA + 1;
        displayForPlayerA(scoreA);
    }

    /**
     * adds one point to the player B score
     */
    public void addOnePointB(View view){
        scoreB = scoreB + 1;
        displayForPlayerB(scoreB);
    }

    public void resetPoints(View view){
        scoreA = 0;
        scoreB = 0;
        displayForPlayerA(scoreA);
        displayForPlayerB(scoreB);
    }

    /**
     * Displays the given score for Player A
     */
    public void displayForPlayerA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Player B
     */
    public void displayForPlayerB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * SETS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     */

    /**
     * adds one set to the player A score
     */
    public void addOneSetA(View view){
        setA = setA + 1;
        displaySetForPlayerA(setA);
    }

    /**
     * adds one set to the player B score
     */
    public void addOneSetB(View view){
        setB = setB + 1;
        displaySetForPlayerB(setB);
    }

    public void resetSets(View view){
        setA = 0;
        setB = 0;
        displaySetForPlayerA(setA);
        displaySetForPlayerB(setB);
    }

    /**
     * Displays the number of sets won by Player A
     */
    public void displaySetForPlayerA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_a_setScore);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the number of sets won by Player B
     */
    public void displaySetForPlayerB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_b_setScore);
        scoreView.setText(String.valueOf(score));
    }

}

