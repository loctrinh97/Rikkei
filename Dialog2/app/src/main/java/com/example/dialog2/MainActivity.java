package com.example.dialog2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnPick;
    Button btnBrightness;
    Button btnLimit;
    Button btnEraseUSB;
    Button btnDate;
    Button btnTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPick = findViewById(R.id.btnPick);
        btnBrightness = findViewById(R.id.btnBrightness);
        btnLimit = findViewById(R.id.btnLimit);
        btnEraseUSB = findViewById(R.id.btnEraseUSB);
        btnDate = findViewById(R.id.btnDate);
        btnTime = findViewById(R.id.btnTime);

        btnDate.setOnClickListener(new View.OnClickListener() {
            private int mYear, mMonth, mDay;

            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        btnTime.setOnClickListener(new View.OnClickListener() {
            private int mHour, mMinute;
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    }
                }, mHour, mMinute, false);
                timePickerDialog.show();
            }
        });

        btnEraseUSB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogEraseUSB();

            }
        });

        btnPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogPick();
            }
        });

        btnBrightness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBrightness();
            }
        });

        btnLimit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogLimit();

            }
        });
    }

    private void dialogEraseUSB() {
        final Dialog dialogEraseUSB = new Dialog(this);
        dialogEraseUSB.setContentView(R.layout.erase_usb);
        dialogEraseUSB.show();

        Button btnOK = dialogEraseUSB.findViewById(R.id.btnOK);
        Button btnCancel = dialogEraseUSB.findViewById(R.id.btnCancel);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogEraseUSB.dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogEraseUSB.cancel();
            }
        });
    }

    private void dialogLimit() {
        final Dialog dialogLimit = new Dialog(this);
        dialogLimit.setContentView(R.layout.text_limit);
        dialogLimit.show();

        Button btnOK = dialogLimit.findViewById(R.id.btnOK);
        Button btnCancel = dialogLimit.findViewById(R.id.btnCancel);
        NumberPicker nbPicker = dialogLimit.findViewById(R.id.nbPicker);
        nbPicker.setMinValue(0);
        nbPicker.setMaxValue(1000);
        nbPicker.setValue(500);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogLimit.dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogLimit.cancel();
            }
        });
    }

    private void dialogPick() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_choose_topping);
        dialog.show();

        final CheckBox cbOnion = dialog.findViewById(R.id.cbOnion);
        final CheckBox cbTomato = dialog.findViewById(R.id.cbTomato);
        final CheckBox cbLettuce = dialog.findViewById(R.id.cbLettuce);
        Button btnOk = dialog.findViewById(R.id.btnOK);
        Button btnCancel = dialog.findViewById(R.id.btnCancel);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> fruitList = new ArrayList<String>();
                if (cbOnion.isChecked()) {
                    fruitList.add("Onion");
                }
                if (cbLettuce.isChecked()) {
                    fruitList.add("Lettuce");
                }
                if (cbTomato.isChecked()) {
                    fruitList.add("Tomato");
                }

                Log.d("TEST", fruitList.toString());
                dialog.dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
    }

    private void dialogBrightness() {
        final Dialog dialogBrightness = new Dialog(this);
        dialogBrightness.setContentView(R.layout.brightness);
        dialogBrightness.show();

        Button btnOK = dialogBrightness.findViewById(R.id.btnOK);
        Button btnCancel = dialogBrightness.findViewById(R.id.btnCancel);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBrightness.dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBrightness.cancel();
            }
        });
    }
}