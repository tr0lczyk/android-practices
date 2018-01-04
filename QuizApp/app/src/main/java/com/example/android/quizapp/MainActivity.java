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
        RadioButton buttonCorrectOne = (RadioButton) findViewById(R.id.one_good_answer);
        boolean oneGoodAnswer = buttonCorrectOne.isChecked();
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
        CheckBox checkBoxCorrectATwo = (CheckBox) findViewById(R.id.two_good_answerA);
        boolean twoGoodAnswerA = checkBoxCorrectATwo.isChecked();
        CheckBox checkBoxCorrectBTwo = (CheckBox) findViewById(R.id.two_good_answerB);
        boolean twoGoodAnswerB = checkBoxCorrectBTwo.isChecked();
        CheckBox checkBoxCorrectCTwo = (CheckBox) findViewById(R.id.two_good_answerC);
        boolean twoGoodAnswerC = checkBoxCorrectCTwo.isChecked();
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
        String falcon = getText(R.string.MilFal).toString();
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
        RadioButton buttonCorrectFour = (RadioButton) findViewById(R.id.four_good_answer);
        boolean oneGoodAnswer = buttonCorrectFour.isChecked();
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
        CheckBox checkBoxCorrectAFive = (CheckBox) findViewById(R.id.five_good_answerA);
        boolean fiveGoodAnswerA = checkBoxCorrectAFive.isChecked();
        CheckBox checkBoxCorrectBFive = (CheckBox) findViewById(R.id.five_good_answerB);
        boolean fiveGoodAnswerB = checkBoxCorrectBFive.isChecked();
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
    * @method that resets all of the answers
    *
    * */
    public void resetQuestions(View view){

//        GOOD ANSWERS
        RadioButton buttonCorrectOne = (RadioButton) findViewById(R.id.one_good_answer);
        buttonCorrectOne.setChecked(false);
        CheckBox checkBoxCorrectATwo = (CheckBox) findViewById(R.id.two_good_answerA);
        checkBoxCorrectATwo.setChecked(false);
        CheckBox checkBoxCorrectBTwo = (CheckBox) findViewById(R.id.two_good_answerB);
        checkBoxCorrectBTwo.setChecked(false);
        CheckBox checkBoxCorrectCTwo = (CheckBox) findViewById(R.id.two_good_answerC);
        checkBoxCorrectCTwo.setChecked(false);
        EditText shipNameCorrect = (EditText) findViewById(R.id.three_good_answer);
        shipNameCorrect.setText("");
        RadioButton buttonCorrectFour = (RadioButton) findViewById(R.id.four_good_answer);
        buttonCorrectFour.setChecked(false);
        CheckBox checkBoxCorrectAFive = (CheckBox) findViewById(R.id.five_good_answerA);
        checkBoxCorrectAFive.setChecked(false);
        CheckBox checkBoxCorrectBFive = (CheckBox) findViewById(R.id.five_good_answerB);
        checkBoxCorrectBFive.setChecked(false);

//        WRONG ANSWERS
        CheckBox checkBoxWrongOne = (CheckBox) findViewById(R.id.bad_checkbox_one);
        checkBoxWrongOne.setChecked(false);
        CheckBox checkBoxWrongTwo = (CheckBox) findViewById(R.id.bad_checkbox_two);
        checkBoxWrongOne.setChecked(false);
        CheckBox checkBoxWrongThree = (CheckBox) findViewById(R.id.bad_checkbox_three);
        checkBoxWrongOne.setChecked(false);
        RadioButton checkRadioButtonWrongOne = (RadioButton) findViewById(R.id.wrong_radio_one);
        checkRadioButtonWrongOne.setChecked(false);
        RadioButton checkRadioButtonWrongTwo = (RadioButton) findViewById(R.id.wrong_radio_two);
        checkRadioButtonWrongTwo.setChecked(false);
        RadioButton checkRadioButtonWrongThree = (RadioButton) findViewById(R.id.wrong_radio_three);
        checkRadioButtonWrongThree.setChecked(false);
        RadioButton checkRadioButtonWrongFour = (RadioButton) findViewById(R.id.wrong_radio_four);
        checkRadioButtonWrongFour.setChecked(false);
        RadioButton checkRadioButtonWrongFive = (RadioButton) findViewById(R.id.wrong_radio_five);
        checkRadioButtonWrongFive.setChecked(false);
        RadioButton checkRadioButtonWrongSix = (RadioButton) findViewById(R.id.wrong_radio_six);
        checkRadioButtonWrongSix.setChecked(false);
    }

    /*
    *
    * @method that checks if the player's name was applied
    *
    * */
    public void isNameThere(View view){
        String yourName = getString(R.string.StateName);
        if (playerName().equals("")) {
            Toast.makeText(this, yourName, Toast.LENGTH_LONG).show();
            return;
        } else {
            displayToast();
        }
    }

    /*
    *
    * @method that displays a different toast message, based on the number of correct answers
    *
    * */
    public void displayToast() {
        int sumOfAnswers = sumOfQuestions(questionOne(), questionTwo(), questionThree(), questionFour(), questionFive());
        String answerZero = playerName() + getString(R.string.Toast1) + sumOfAnswers + getString(R.string.Toast2);
        String answerOne = playerName() + getString(R.string.Toast3) + sumOfAnswers + getString(R.string.Toast4);
        String answerTwo = getString(R.string.Toast5) + playerName() + getString(R.string.Toast6) + sumOfAnswers + getString(R.string.Toast7);
        String answerThree = getString(R.string.Toast8) + playerName() + getString(R.string.Toast9) + sumOfAnswers + getString(R.string.Toast10);
        String answerFour = getString(R.string.Toast11) + playerName() + getString(R.string.Toast12) + sumOfAnswers + getString(R.string.Toast13);
        String answerFive = getString(R.string.Toast14) + playerName() + getString(R.string.Toast15) + sumOfAnswers + getString(R.string.Toast16);
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
    }
}

