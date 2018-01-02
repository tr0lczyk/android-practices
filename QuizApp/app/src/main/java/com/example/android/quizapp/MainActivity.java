package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

    public void displayToast(View view){
        Toast.makeText(this, "Congratulations " + playerName() + "! 6/6 answers correct! The force is strong in you...", Toast.LENGTH_SHORT).show();
    }
}
