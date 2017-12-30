package com.example.android.javapractice;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView plum = new TextView(this);
        plum.setText("pupapupapupapupapupapupapupapupapupapupapupapupapupapupapupapupapupapupapupapupapupapupapupapupapupapupapupapupapupa");
        plum.setTextColor(Color.MAGENTA);;
        plum.setTextSize(40);
        plum.setMaxLines(4);
        setContentView(plum);
    }
}
