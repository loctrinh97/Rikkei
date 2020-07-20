package com.example.rikkeiactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class ActivityA extends AppCompatActivity {
    private static final String TAG = "MyActivity";
    private static double startTimeA;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        mediaPlayer = MediaPlayer.create(this, R.raw.cu_chill_thoi);
        if (savedInstanceState != null) {
            startTimeA = savedInstanceState.getDouble("timeStart");
        }
        Log.d(TAG, "msg:onCreateA " + startTimeA);
        mediaPlayer.start();
        Button btnA = findViewById(R.id.btnSwitchA);
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityA.this, ActivityB.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        if (!mediaPlayer.isPlaying()){
            mediaPlayer.seekTo((int)startTimeA);
            mediaPlayer.start();
        }
        super.onStart();
        Log.d(TAG, "msg:onStartA");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "msg:onResumeA");
    }

    @Override
    protected void onPause() {
        mediaPlayer.pause();
        startTimeA = mediaPlayer.getCurrentPosition();
        super.onPause();
        Log.d(TAG, "msg:onPauseA " + startTimeA);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("timeStart", mediaPlayer.getCurrentPosition());
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "msg:onStopA " + startTimeA);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "msg:onDestroyA");
    }
}