package com.example.android.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        double startTime = 0;
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.skyrim_sound);

        Button playButton = findViewById(R.id.buttonPlay);
        final Button pauseButton = findViewById(R.id.buttonPause);
        Button stopButton = findViewById(R.id.buttonStop);
        pauseButton.setEnabled(false);
        SeekBar seekBar = findViewById(R.id.seekBar);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                pauseButton.setEnabled(true);
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.reset();
            }
        });
    }
}
