package com.example.android.profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView name = findViewById(R.id.name);
        name.setText("Natalia");
        TextView birthday = findViewById(R.id.birthday);
        birthday.setText("9th od August");
        TextView country = findViewById(R.id.country);
        country.setText("Poland");
        ImageView picture = findViewById(R.id.picture_profile);
        picture.setImageResource(R.drawable.mill);
    }
}
