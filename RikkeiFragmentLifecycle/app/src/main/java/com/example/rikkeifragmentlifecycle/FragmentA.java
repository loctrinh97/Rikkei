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

public class FragmentA extends Fragment {
    MediaPlayer mediaPlayer;
    private static double saveTime;
    FragmentTransaction fragmentTransaction;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("fragmentA", "fragmentA: onCreate");
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        Log.d("fragmentA", "fragmentA: onCreateView");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mediaPlayer = MediaPlayer.create(getActivity().getApplicationContext(),R.raw.bigcitiboi);
        Log.d("fragmentA", "fragmentA: onActivityCreated");
        Button btnGoB = (Button) getView().findViewById(R.id.btnGoB);
        btnGoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTime = mediaPlayer.getCurrentPosition();
                mediaPlayer.stop();
                FragmentB fragmentB = new FragmentB();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container,fragmentB);
                fragmentTransaction.addToBackStack(String.valueOf(saveTime));
                Log.d("test", String.valueOf(saveTime));
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
        Log.d("fragmentA", "fragmentA: onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d("fragmentA", "fragmentA: onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d("fragmentA", "fragmentA: onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d("fragmentA", "fragmentA: onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d("fragmentA", "fragmentA: onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d("fragmentA", "fragmentA: onDestroy");
        super.onDestroy();
        getFragmentManager().popBackStack();
        fragmentTransaction.commit();
    }
}
