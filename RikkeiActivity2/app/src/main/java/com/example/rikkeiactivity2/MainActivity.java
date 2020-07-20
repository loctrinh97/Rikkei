package com.example.rikkeiactivity2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";
    private static double startTimeA;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this, R.raw.how_you_like_that);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        startTimeA = savedInstanceState.getDouble("timeStart");
        mediaPlayer.seekTo((int)startTimeA);
    }

    @Override
    protected void onStart() {
        super.onStart();
    //    Log.d(TAG, "msg:onStartA");
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.start();
    //    Log.d(TAG, "msg:onResumeA");
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