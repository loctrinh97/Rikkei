package com.example.rikkeifragmentlifecycle;

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

public class FragmentB extends Fragment {
    MediaPlayer mediaPlayer;
    private static double saveTime;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("fragmentB", "fragmentB: onCreate");
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        Log.d("fragmentB", "fragmentB: onCreateView");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mediaPlayer = MediaPlayer.create(getActivity().getApplicationContext(),R.raw.embothuocchua);
        Log.d("fragmentB", "fragmentB: onActivityCreated");
        Button btnGoA = (Button) getView().findViewById(R.id.btnGoA);
        btnGoA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTime = mediaPlayer.getCurrentPosition();
                mediaPlayer.stop();

                FragmentA fragmentA = new FragmentA();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container,fragmentA);
                fragmentTransaction.addToBackStack(String.valueOf(saveTime));
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public void onStart() {
        if (!mediaPlayer.isPlaying()){
            Log.d("test1", String.valueOf(saveTime));
            mediaPlayer.seekTo((int)saveTime);
            mediaPlayer.start();
        }
        Log.d("fragmentB", "fragmentB: onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d("fragmentB", "fragmentB: onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d("fragmentB", "fragmentB: onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d("fragmentB", "fragmentB: onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d("fragmentB", "fragmentB: onDestroyView");
        super.onDestroyView();
        mediaPlayer.stop();
    }

    @Override
    public void onDestroy() {
        Log.d("fragmentB", "fragmentB: onDestroy");
        super.onDestroy();
    }
}
