package com.example.android.quizapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void createButton(){
        ViewGroup linearLayout = (ViewGroup) findViewById(R.id.main_questions_layout);
        Button resetButton = new Button(this);
        resetButton.setText("Reset");
        resetButton.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        resetButton.setPadding(16, 16,16,16);
        resetButton.setGravity(Gravity.CENTER_HORIZONTAL);
        resetButton.setTextColor(R.color.colorPrimary);
        linearLayout.addView(resetButton);
    }

}
