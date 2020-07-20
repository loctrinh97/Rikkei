package com.example.rikkeirecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Infor> mInfors;
    private InforAdapter inforAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRvInfor = findViewById(R.id.rvInfor);
        mInfors = new ArrayList<>();
        mInfors.add(new Infor(R.drawable.a, "mot ne"));
        mInfors.add(new Infor(R.drawable.b, "hai ne"));
        mInfors.add(new Infor(R.drawable.c, "ba ne"));
        mInfors.add(new Infor(R.drawable.d, "bon ne"));
        mInfors.add(new Infor(R.drawable.e, "nam ne"));

        inforAdapter = new InforAdapter(mInfors, this);
        mRvInfor.setAdapter(inforAdapter);

//        ********LinearLayoutManager
//        mRvInfor.setLayoutManager(new LinearLayoutManager(this));

//        ********StaggeredGridLayoutManager
//        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
//        mRvInfor.setLayoutManager(layoutManager);
//        mRvInfor.setHasFixedSize(true);

//        ********GridLayoutManager
        GridLayoutManager layoutManager = new GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false);
        mRvInfor.setLayoutManager(layoutManager);
    }
}