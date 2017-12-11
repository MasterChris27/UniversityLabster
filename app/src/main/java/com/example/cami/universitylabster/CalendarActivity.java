package com.example.cami.universitylabster;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;

import java.sql.Date;

/**
 * Created by Cami on 09.12.2017.
 */


public class CalendarActivity extends AppCompatActivity {
    private static final String TAG = "CalendarActivity";
    private CalendarView mCalendarView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_layout);
        mCalendarView= findViewById(R.id.calendarView);
        mCalendarView.setOnDateChangeListener(
                new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                        Date data= new Date(year-1901,month+1,dayOfMonth);
                        Intent intent = new Intent(CalendarActivity.this,download_info.class);
                        intent.putExtra("data",data.toString());
                        startActivity(intent);
                    }

                });

    }
}
