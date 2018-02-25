package com.example.android.javapractice;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView test = findViewById(R.id.test);
        final TextView test2 = findViewById(R.id.testRoll);
        Button turn = findViewById(R.id.turn_on);

        turn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String boom2 = keepRoll();
                test.setText("The dices were rolled " + boom2 + " times.");
                String boom3 = rollDiceString();
                test2.setText(" " + boom3);
            }
        });
    }

    public int rollDice(){
        int num = 0;
        int roll = 0;
        Random randomRoll = new Random();
        roll = randomRoll.nextInt(6)+1;
        num += roll;
        return num;
    }
    public String keepRoll() {
        int dice1 = rollDice();
        int dice2 = rollDice();
        int dice3 = rollDice();
        int dice4 = rollDice();
        int dice5 = rollDice();
        int count = 1;
        while (!(dice1 == dice2 && dice2 == dice3 && dice3 == dice4 && dice4 == dice5)){
            dice1 = rollDice();
            dice2 = rollDice();
            dice3 = rollDice();
            dice4 = rollDice();
            dice5 = rollDice();
            count += 1;
        }
        String boom = String.valueOf(count);
        return boom;
    }

    public String rollDiceString(){
        int outcome = rollDice();
        String rollDiceOutcome = String.valueOf(outcome);
        return rollDiceOutcome;
    }
}


