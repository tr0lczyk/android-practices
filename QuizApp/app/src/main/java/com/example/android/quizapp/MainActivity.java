package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public String playerName(){
        EditText name = (EditText) findViewById(R.id.player_name);
        String namePlayer = name.getText().toString();
        return namePlayer;
    }

    public int questionOne(){
        RadioButton buttonCorrect = (RadioButton) findViewById(R.id.one_good_answear);
        boolean oneGoodAnswear = buttonCorrect.isChecked();
        if (oneGoodAnswear) {
            return 1;
        } else {
            return 0;
        }
    }

    public int questionTwo(){
        CheckBox checkBoxCorrectA = (CheckBox) findViewById(R.id.two_good_answearA);
        boolean twoGoodAnswearA = checkBoxCorrectA.isChecked();
        CheckBox checkBoxCorrectB = (CheckBox) findViewById(R.id.two_good_answearB);
        boolean twoGoodAnswearB = checkBoxCorrectB.isChecked();
        CheckBox checkBoxCorrectC = (CheckBox) findViewById(R.id.two_good_answearC);
        boolean twoGoodAnswearC = checkBoxCorrectC.isChecked();
        if (twoGoodAnswearA && twoGoodAnswearB && twoGoodAnswearC) {
            return 1;
        } else {
            return 0;
        }
    }

    public int questionThree(){
        EditText shipNameCorrect = (EditText) findViewById(R.id.three_good_answear);
        String threeGoodAnswear = shipNameCorrect.getText().toString().toLowerCase();
        String falcon = "millenium falcon";
        if (threeGoodAnswear.equals(falcon)) {
            return 1;
        } else {
            return 0;
        }
    }

    public int questionFour(){
        RadioButton buttonCorrect = (RadioButton) findViewById(R.id.four_good_answear);
        boolean oneGoodAnswear = buttonCorrect.isChecked();
        if (oneGoodAnswear) {
            return 1;
        } else {
            return 0;
        }
    }

    public int questionFive(){
        CheckBox checkBoxCorrectA = (CheckBox) findViewById(R.id.five_good_answearA);
        boolean fiveGoodAnswearA = checkBoxCorrectA.isChecked();
        CheckBox checkBoxCorrectB = (CheckBox) findViewById(R.id.five_good_answearB);
        boolean fiveGoodAnswearB = checkBoxCorrectB.isChecked();
        CheckBox checkBoxCorrectC = (CheckBox) findViewById(R.id.five_good_answearC);
        boolean fiveGoodAnswearC = checkBoxCorrectC.isChecked();
        if (fiveGoodAnswearA && fiveGoodAnswearB && fiveGoodAnswearC) {
            return 1;
        } else {
            return 0;
        }
    }

    public int sumOfQuestions(int quest,int quest2, int quest3, int quest4, int quest5) {
        int correctAnswears = 0;
        correctAnswears += quest + quest2 + quest3 + quest4 + quest5;
        return correctAnswears;
    }

    public void displayToast(View view){
        int sumOfAnswers = sumOfQuestions(questionOne(), questionTwo(),questionThree(), questionFour(), questionFive());
        String answearZero = playerName() + ", do. Or do not. There is no try. Your score is " + sumOfAnswers + " points...";
        String answearOne = playerName() + ", I have a bad feelings about this... " + sumOfAnswers + "/5 question answered correctly.";
        String answearTwo = "Not bad " + playerName() + "! " + sumOfAnswers + "/5 points! In my experience there is no such thing as luck.";
        String answearThree = "Nice, " + playerName() + "! Your score is " + sumOfAnswers + "/5! Stay on target.";
        String answearFour = "Great " + playerName() + "! " + "but don’t get cocky. " + sumOfAnswers + "/5 questions answered correctly!";
        String answearFive = "Marvelous " + playerName() +", your score is" + sumOfAnswers + "/5 ! The force is strong in you...";
        if (sumOfAnswers == 0){
            Toast.makeText(this, answearZero, Toast.LENGTH_LONG).show();
        } else if (sumOfAnswers == 1) {
            Toast.makeText(this, answearOne, Toast.LENGTH_LONG).show();
        } else if (sumOfAnswers == 2) {
            Toast.makeText(this, answearTwo, Toast.LENGTH_LONG).show();
        } else if (sumOfAnswers == 3) {
            Toast.makeText(this, answearThree, Toast.LENGTH_LONG).show();
        } else if (sumOfAnswers == 4) {
            Toast.makeText(this, answearFour, Toast.LENGTH_LONG).show();
        } else if (sumOfAnswers == 5) {
            Toast.makeText(this, answearFive, Toast.LENGTH_LONG).show();
        }
    }
}
