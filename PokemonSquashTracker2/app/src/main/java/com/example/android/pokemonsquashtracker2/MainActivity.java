package com.example.android.pokemonsquashtracker2;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.AssetManager;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.pokemonsquashtracker2.R;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    /*
    * @Global Variables
    *
    * */

    ProgressBar prgR;
    ProgressBar prgB;

    int redScore = 0;
    int blueScore = 0;
    int redMatchScore = 0;
    int blueMatchScore = 0;

    ImageView charizard;
    ImageView blastoise;
    ImageView blastoiseAttack;
    ImageView charizardAttack;

    Animation blastoiseFloat;
    Animation charizardFloat;

    static final String RED_SCORE = "red_Score";
    static final String BLUE_SCORE = "blue_Score";
    static final String RED_MATCH_SCORE = "red_Match_Score";
    static final String BLUE_MATCH_SCORE = "blue_Match_Score";

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt(RED_SCORE, redScore);
        savedInstanceState.putInt(BLUE_SCORE, blueScore);
        savedInstanceState.putInt(RED_MATCH_SCORE, redMatchScore);
        savedInstanceState.putInt(BLUE_MATCH_SCORE, blueMatchScore);
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Check whether we're recreating a previously destroyed instance
        if (savedInstanceState != null) {
            // Restore value of members from saved state
            redScore = savedInstanceState.getInt(RED_SCORE);
            blueScore = savedInstanceState.getInt(BLUE_SCORE);
            redMatchScore = savedInstanceState.getInt(RED_MATCH_SCORE);
            blueMatchScore = savedInstanceState.getInt(BLUE_MATCH_SCORE);
        } else {
            redScore = 0;
            blueScore = 0;
            redMatchScore = 0;
            blueMatchScore = 0;
        }
        setContentView(R.layout.activity_main);
        displayScoreR(redScore);
        displayScoreB(blueScore);
        displayMatchScoreR(redMatchScore);
        displayMatchScoreB(blueMatchScore);

        blastoise = findViewById(R.id.blastoise_image);
        charizard = findViewById(R.id.charizard_image);
        blastoiseAttack = findViewById(R.id.water_wave);
        charizardAttack = findViewById(R.id.fire_wave);

        blastoiseFloat = AnimationUtils.loadAnimation(this, R.anim.blastoisefloat);
        charizardFloat = AnimationUtils.loadAnimation(this, R.anim.charizardfloat);

        blastoise.startAnimation(blastoiseFloat);
        charizard.startAnimation(charizardFloat);

        prgR = findViewById(R.id.red_progress_bar);
        prgB = findViewById(R.id.blue_progress_bar);


    }

    /*
    * @method that displays Red player match score
    *
    * */

    public void displayMatchScoreR(int score) {
        TextView matchView = findViewById(R.id.red_match_score);
        matchView.setText(String.valueOf(score));
    }

    /*
    * @method that displays Blue player match score
    *
    * */

    public void displayMatchScoreB(int score) {
        TextView matchView = findViewById(R.id.blue_match_score);
        matchView.setText(String.valueOf(score));
    }

    /*
    * @method that displays Red player game score
    *
    * */

    public void displayScoreR(int score) {
        TextView scoreView = findViewById(R.id.red_score);
        scoreView.setText(String.valueOf(score));
    }

    /*
    * @method that displays Blue player game score
    *
    * */

    public void displayScoreB(int score) {
        TextView scoreView = findViewById(R.id.blue_score);
        scoreView.setText(String.valueOf(score));
    }

    /*
    * @method that resets whole match and every game
    *
    * */

    public void resetFunction() {
        prgR.setProgress(110);
        prgB.setProgress(110);
        redScore = 0;
        displayScoreR(redScore);
        blueScore = 0;
        displayScoreB(blueScore);
        redMatchScore = 0;
        displayMatchScoreR(redMatchScore);
        blueMatchScore = 0;
        displayMatchScoreB(blueMatchScore);
    }

    /*
    * @method that resets last game
    *
    * */

    public void gameResetFunction() {
        prgR.setProgress(110);
        prgB.setProgress(110);
        redScore = 0;
        displayScoreR(redScore);
        blueScore = 0;
        displayScoreB(blueScore);
    }

    /*
    * @method that connects the button to the resetFunction
    *
    * */

    public void resetButton(View view) {
        resetFunction();
    }

    /*
    * Animation of the Blastoise attack
    *
    * */

    public void blueAttacks() {
        blastoiseAttack.setVisibility(View.VISIBLE);
        blastoiseAttack.animate().alpha(1.0f).setDuration(200).withEndAction(new Runnable() {
            @Override
            public void run() {
                blastoiseAttack.setVisibility(View.GONE);
            }
        });
    }

    /*
    * Animation of the Charizard attack
    *
    * */

    public void redAttacks() {
        charizardAttack.setVisibility(View.VISIBLE);
        charizardAttack.animate().alpha(1.0f).setDuration(200).withEndAction(new Runnable() {
            @Override
            public void run() {
                charizardAttack.setVisibility(View.GONE);
            }
        });
    }

    /*
    * @method that adding 1 point for the red player, displaying the score of games and matches and commencing attack
    *
    * */

    public void plusOneRed(View view) {
        redAttacks();
        prgB.incrementProgressBy(-10);
        redScore += 1;
        displayScoreR(redScore);
        if (redScore >= 11 && blueScore <= (redScore - 2)) {
            redMatchScore += 1;
            displayMatchScoreR(redMatchScore);
            if (redMatchScore <= 2) {
                Toast gameToast = Toast.makeText(this, R.string.red_wins_game, Toast.LENGTH_SHORT);
                gameToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                gameToast.show();
            }
            if (redMatchScore == 3 && blueMatchScore <= 2) {
                Toast matchToast = Toast.makeText(this, getString(R.string.red_won_match) + redMatchScore + getString(R.string.colon) + blueMatchScore + getString(R.string.astonish_victory), Toast.LENGTH_LONG);
                matchToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                matchToast.show();
                resetFunction();
            } else {
                gameResetFunction();
            }
        }
    }

    /*
    * @method that adding 1 point for the blue player, displaying the score of games and matches and commencing attack
    *
    * */

    public void plusOneBlue(View view) {
        blueAttacks();
        prgR.incrementProgressBy(-10);
        blueScore += 1;
        displayScoreB(blueScore);
        if (blueScore >= 11 && redScore <= (blueScore - 2)) {
            blueMatchScore += 1;
            displayMatchScoreB(blueMatchScore);
            if (blueMatchScore <= 2) {
                Toast gameToast = Toast.makeText(this, R.string.blue_wins_game, Toast.LENGTH_SHORT);
                gameToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                gameToast.show();
            }
            if (blueMatchScore == 3 && redMatchScore <= 2) {
                Toast matchToast = Toast.makeText(this, getString(R.string.blue_won_match) + blueMatchScore + getString(R.string.colon) + redMatchScore + getString(R.string.astonish_victory), Toast.LENGTH_LONG);
                matchToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                matchToast.show();
                resetFunction();
            } else {
                gameResetFunction();
            }
        }
    }
}