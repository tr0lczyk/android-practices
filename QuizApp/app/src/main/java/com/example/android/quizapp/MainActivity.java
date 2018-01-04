package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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


    /*
    *
    * @method that return's the player name
    *
    *
    * */
    public String playerName() {
        EditText name = (EditText) findViewById(R.id.player_name);
        String namePlayer = name.getText().toString();
        return namePlayer;
    }

    /*
    *
    * @method that checks if the player choose the answer for the first question correctly
    *
    * */
    public int questionOne() {
        RadioButton buttonCorrect = (RadioButton) findViewById(R.id.one_good_answer);
        boolean oneGoodAnswer = buttonCorrect.isChecked();
        if (oneGoodAnswer) {
            return 1;
        } else {
            return 0;
        }
    }

    /*
    *
    * @method that checks if the player choose the answer for the second question correctly
    *
    * */
    public int questionTwo() {
        CheckBox checkBoxCorrectA = (CheckBox) findViewById(R.id.two_good_answerA);
        boolean twoGoodAnswerA = checkBoxCorrectA.isChecked();
        CheckBox checkBoxCorrectB = (CheckBox) findViewById(R.id.two_good_answerB);
        boolean twoGoodAnswerB = checkBoxCorrectB.isChecked();
        CheckBox checkBoxCorrectC = (CheckBox) findViewById(R.id.two_good_answerC);
        boolean twoGoodAnswerC = checkBoxCorrectC.isChecked();
        if (twoGoodAnswerA && twoGoodAnswerB && twoGoodAnswerC) {
            return 1;
        } else {
            return 0;
        }
    }

    /*
    *
    * @method that checks if the player choose the answer for the third question correctly
    *
    * */
    public int questionThree() {
        EditText shipNameCorrect = (EditText) findViewById(R.id.three_good_answer);
        String threeGoodAnswer = shipNameCorrect.getText().toString().toLowerCase();
        String falcon = "millenium falcon";
        if (threeGoodAnswer.equals(falcon)) {
            return 1;
        } else {
            return 0;
        }
    }

    /*
    *
    * @method that checks if the player choose the answer for the fourth question correctly
    *
    * */
    public int questionFour() {
        RadioButton buttonCorrect = (RadioButton) findViewById(R.id.four_good_answer);
        boolean oneGoodAnswer = buttonCorrect.isChecked();
        if (oneGoodAnswer) {
            return 1;
        } else {
            return 0;
        }
    }

    /*
    *
    * @method that checks if the player choose the answer for the fifth question correctly
    *
    * */
    public int questionFive() {
        CheckBox checkBoxCorrectA = (CheckBox) findViewById(R.id.five_good_answerA);
        boolean fiveGoodAnswerA = checkBoxCorrectA.isChecked();
        CheckBox checkBoxCorrectB = (CheckBox) findViewById(R.id.five_good_answerB);
        boolean fiveGoodAnswerB = checkBoxCorrectB.isChecked();
        if (fiveGoodAnswerA && fiveGoodAnswerB) {
            return 1;
        } else {
            return 0;
        }
    }

    /*
    *
    * @method that checks total number of correct answers
    *
    * */
    public int sumOfQuestions(int quest, int quest2, int quest3, int quest4, int quest5) {
        int correctAnswers = 0;
        correctAnswers += quest + quest2 + quest3 + quest4 + quest5;
        return correctAnswers;
    }


    /*
    *
    * @method that checks if the player's name was applied
    *
    * */
    public void isNameThere(View view){
        String yourName = "Padawan, please state your name...";
        if (playerName().equals("")) {
            Toast.makeText(this, yourName, Toast.LENGTH_LONG).show();
            return;
        } else {
            displayToast();
        }
    }

    public void createButton(){
        ViewGroup linearLayout = (ViewGroup) findViewById(R.id.main_questions_layout);
        Button resetButton = new Button(this);
        resetButton.setText("Reset");
        resetButton.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        resetButton.setGravity(Gravity.CENTER_HORIZONTAL);
        linearLayout.addView(resetButton);
    }

    /*
    *
    * @method that displays a different toast message, based on the number of correct answers
    *
    * */
    public void displayToast() {
        int sumOfAnswers = sumOfQuestions(questionOne(), questionTwo(), questionThree(), questionFour(), questionFive());
        String answerZero = playerName() + ", do. Or do not. There is no try. Your score is " + sumOfAnswers + " points...";
        String answerOne = playerName() + ", I have a bad feelings about this... " + sumOfAnswers + "/5 question answered correctly.";
        String answerTwo = "Not bad " + playerName() + "! " + sumOfAnswers + "/5 points! In my experience there is no such thing as luck.";
        String answerThree = "Nice, " + playerName() + "! Your score is " + sumOfAnswers + "/5! Stay on target.";
        String answerFour = "Great " + playerName() + ", " + "but don’t get cocky. " + sumOfAnswers + "/5 questions answered correctly!";
        String answerFive = "Marvelous " + playerName() + ", your score is" + sumOfAnswers + "/5 ! The force is strong in you...";
        if (sumOfAnswers == 0) {
            Toast.makeText(this, answerZero, Toast.LENGTH_LONG).show();
            return;
        } else if (sumOfAnswers == 1) {
            Toast.makeText(this, answerOne, Toast.LENGTH_LONG).show();
        } else if (sumOfAnswers == 2) {
            Toast.makeText(this, answerTwo, Toast.LENGTH_LONG).show();
        } else if (sumOfAnswers == 3) {
            Toast.makeText(this, answerThree, Toast.LENGTH_LONG).show();
        } else if (sumOfAnswers == 4) {
            Toast.makeText(this, answerFour, Toast.LENGTH_LONG).show();
        } else if (sumOfAnswers == 5) {
            Toast.makeText(this, answerFive, Toast.LENGTH_LONG).show();
        }
        createButton();
    }
}

