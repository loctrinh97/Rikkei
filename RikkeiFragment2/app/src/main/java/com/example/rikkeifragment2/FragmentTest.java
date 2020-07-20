package com.example.rikkeifragment2;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentTest extends Fragment {

    MediaPlayer mediaPlayer;
    private static double saveTime;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("fragmentA", "fragmentA: onCreate");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        Log.d("fragmentA", "fragmentA: onCreateView");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mediaPlayer = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.bigcitiboi);
        Log.d("fragmentA", "fragmentA: onActivityCreated");
        if(savedInstanceState != null){
            saveTime = savedInstanceState.getDouble("timeStart");
        }
       // mediaPlayer.start();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("timeStart", mediaPlayer.getCurrentPosition());
    }

    @Override
    public void onStart() {
        Log.d("fragmentA", "fragmentA: onStart");
        super.onStart();
        if (!mediaPlayer.isPlaying()){
            mediaPlayer.seekTo((int)saveTime);
            mediaPlayer.start();
        }
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        super.onDestroy();
    }
}
