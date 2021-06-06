package com.devss.schedule;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class NewScheduleActivity extends AppCompatActivity {

    private TextView textView;
    private int hour, minute;
    private String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_schedule);

        textView = findViewById(R.id.tv);
        final Calendar calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(NewScheduleActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if (hourOfDay > 12) {
                            hourOfDay = hourOfDay - 12;
                            time = hourOfDay + " : " + minute + " P.M.";
                        } else {
                            time = hourOfDay + " : " + minute + " A.M.";
                        }
                        textView.setText(time);
                    }
                }, hour, minute, false);

                timePickerDialog.show();
            }
        });
    }
}