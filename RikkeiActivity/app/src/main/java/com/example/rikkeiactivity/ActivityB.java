package com.example.rikkeiactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActivityB extends AppCompatActivity {
    private static final String TAG = "MyActivity";
    private static double startTimeB;
    MediaPlayer mediaPlayerB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        mediaPlayerB = MediaPlayer.create(this,R.raw.mot_cu_lua);

        if (savedInstanceState != null ) {
            startTimeB = savedInstanceState.getDouble("timeStartB");
        }
        Log.d(TAG, "msg:onCreateB " + startTimeB);
        mediaPlayerB.seekTo((int)startTimeB);
        mediaPlayerB.start();

//        Button btnB = findViewById(R.id.btnSwitchB);
//        btnB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent= new Intent(ActivityB.this, ActivityA.class);
//                startActivity(intent);
//            }
//        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG,"msg:onStartB");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"msg:onResumeB");
    }

    @Override
    protected void onPause() {
        mediaPlayerB.pause();
        startTimeB = mediaPlayerB.getCurrentPosition();
        super.onPause();
        Log.d(TAG,"msg:onPauseB "+startTimeB);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG,"msg:save "+ mediaPlayerB.getCurrentPosition());
        outState.putDouble("timeStartB", mediaPlayerB.getCurrentPosition());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"msg:onStopB");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"msg:onDestroyB");
    }
}