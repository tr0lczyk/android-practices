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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blastoise =  findViewById(R.id.blastoise_image);
        charizard =  findViewById(R.id.charizard_image);
        blastoiseAttack =  findViewById(R.id.water_wave);
        charizardAttack =  findViewById(R.id.fire_wave);

        blastoiseFloat = AnimationUtils.loadAnimation(this, R.anim.blastoisefloat);
        charizardFloat = AnimationUtils.loadAnimation(this, R.anim.charizardfloat);

        blastoise.startAnimation(blastoiseFloat);
        charizard.startAnimation(charizardFloat);

        prgR =  findViewById(R.id.red_progress_bar);
        prgB =  findViewById(R.id.blue_progress_bar);
    }

    public void displayMatchScoreR(int score) {
        TextView matchView = (TextView) findViewById(R.id.red_match_score);
        matchView.setText(String.valueOf(score));
    }

    public void displayMatchScoreB(int score) {
        TextView matchView = (TextView) findViewById(R.id.blue_match_score);
        matchView.setText(String.valueOf(score));
    }

    public void displayScoreR(int score) {
        TextView scoreView = (TextView) findViewById(R.id.red_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayScoreB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.blue_score);
        scoreView.setText(String.valueOf(score));
    }

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

    public void gameResetFunction() {
        prgR.setProgress(110);
        prgB.setProgress(110);
        redScore = 0;
        displayScoreR(redScore);
        blueScore = 0;
        displayScoreB(blueScore);
    }

    public void resetButton(View view) {
        resetFunction();
    }

    public void blueAttacks() {
        blastoiseAttack.setVisibility(View.VISIBLE);
        blastoiseAttack.animate().alpha(1.0f).setDuration(200).withEndAction(new Runnable() {
            @Override
            public void run() {
                blastoiseAttack.setVisibility(View.GONE);
            }
        });
    }

    public void redAttacks() {
        charizardAttack.setVisibility(View.VISIBLE);
        charizardAttack.animate().alpha(1.0f).setDuration(200).withEndAction(new Runnable() {
            @Override
            public void run() {
                charizardAttack.setVisibility(View.GONE);
            }
        });
    }

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