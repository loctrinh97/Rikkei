package com.example.rikkeiintentflag2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityA extends AppCompatActivity {
    private static final int REQUEST_CODE = 100;
    public String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Button btnAtoB = findViewById(R.id.btnAtoB);
        btnAtoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityA.this,ActivityB.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE ){
            if (resultCode == RESULT_OK){
                 result = data.getStringExtra("Key");
                Toast.makeText(this, "Result: " + result, Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this, "Fail",Toast.LENGTH_LONG);
            }
        }
    }
}