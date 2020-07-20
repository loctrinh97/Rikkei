package com.example.dialog1;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    Button btnChoose;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChoose = findViewById(R.id.btnChoose);
        tv = findViewById(R.id.tVcheck);
        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                final String[] arrFruit = new String[]{"Onion", "Lettuce", "Tomato"};
                final boolean[] checked = new boolean[]{
                        false, true, true
                };
                tv.setText("");
                final List<String> fruitList = Arrays.asList(arrFruit);
                alert.setTitle("Pick your toppings");
                alert.setMultiChoiceItems(arrFruit, checked, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checked[which] = isChecked;
                        String arrFruits = fruitList.get(which);
                        Toast.makeText(MainActivity.this, arrFruits + " " + isChecked, Toast.LENGTH_LONG);
                    }
                });

                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < checked.length; i++) {
                            if (checked[i] == true) {
                                tv.setText(tv.getText() +" "+ fruitList.get(i));
                            }
                        }
                    }
                });


                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog = alert.create();
                dialog.show();
            }
        });

    }


}