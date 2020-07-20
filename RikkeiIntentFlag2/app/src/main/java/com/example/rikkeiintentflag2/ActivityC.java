package com.example.rikkeiintentflag2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityC extends AppCompatActivity {
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        Button btnCtoA =findViewById(R.id.btnCtoA);
        Intent intent1 = getIntent();
        data = intent1.getStringExtra("data");
        btnCtoA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityC.this,ActivityA.class);
                intent.putExtra("Key",data);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}