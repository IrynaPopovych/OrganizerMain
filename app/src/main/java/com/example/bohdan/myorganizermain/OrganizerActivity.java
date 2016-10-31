package com.example.bohdan.myorganizermain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.p_v.flexiblecalendar.FlexibleCalendarView;
import com.p_v.flexiblecalendar.entity.Event;
import com.p_v.flexiblecalendar.view.BaseCellView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by irkap on 30.10.2016.
 */

public class OrganizerActivity extends AppCompatActivity implements  FlexibleCalendarView.OnDateClickListener {
    private FlexibleCalendarView flexibleCalendarView;
    private Toolbar toolbar;


    @Override
    public  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizer);
        initViews();
    }

    public void setContentView(int activity_main) {
    }

    private void initViews() {
        toolbar = (Toolbar) flexibleCalendarView.findViewById(R.id.toolbar);

        initCalendar();

    }

    private void initCalendar() {
        flexibleCalendarView = (FlexibleCalendarView) flexibleCalendarView.findViewById(R.id.flexible_calendar);
        flexibleCalendarView.setOnDateClickListener(this);
        flexibleCalendarView.setOnMonthChangeListener(new FlexibleCalendarView.OnMonthChangeListener() {
            @Override
            public void onMonthChange(int year, int month, int direction) {
                Calendar cal = Calendar.getInstance();
                cal.set(year, month, 1);
                //Toast.makeText(CalendarFragment.this, cal.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.ENGLISH) + " " + year, Toast.LENGTH_SHORT).show();
            }
        });
        flexibleCalendarView.setCalendarView(new FlexibleCalendarView.CalendarView() {
            @Override
            public BaseCellView getCellView(int position, View convertView, ViewGroup parent, int cellType) {
                BaseCellView cellView = (BaseCellView) convertView;
                if (cellView == null) {
                    LayoutInflater inflater = LayoutInflater.from(getParent());
                    cellView = (BaseCellView) inflater.inflate(R.layout.cell_view, null);
                }
                if (cellType == BaseCellView.TODAY) {
                    cellView.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                    cellView.setTextSize(15);
                } else {
                    cellView.setTextColor(getResources().getColor(android.R.color.white));
                    cellView.setTextSize(12);
                }
                return cellView;
            }

            @Override
            public BaseCellView getWeekdayCellView(int position, View convertView, ViewGroup parent) {
                BaseCellView cellView = (BaseCellView) convertView;
                if (cellView == null) {
                    LayoutInflater inflater;
                    inflater = LayoutInflater.from(getParent());
                    cellView = (BaseCellView) inflater.inflate(R.layout.week_cell_view, null, false);
                }
                return cellView;
            }

            @Override
            public String getDayOfWeekDisplayValue(int dayOfWeek, String defaultValue) {
                return null;
            }
        });


        flexibleCalendarView.setEventDataProvider(new FlexibleCalendarView.EventDataProvider() {
            @Override
            public List<? extends Event> getEventsForTheDay(int year, int month, int day) {
                if(year==2016 && month == 8 && day == 25){
                    List<CustomEvent> colorLst1 = new ArrayList<>();
                    colorLst1.add(new CustomEvent(android.R.color.holo_green_dark));
                    colorLst1.add(new CustomEvent(android.R.color.holo_blue_light));
                    colorLst1.add(new CustomEvent(android.R.color.holo_purple));
                    return colorLst1;
                }
                if(year==2016 && month == 8 && day == 8){
                    List<CustomEvent> colorLst1 = new ArrayList<>();
                    colorLst1.add(new CustomEvent(android.R.color.holo_green_dark));
                    colorLst1.add(new CustomEvent(android.R.color.holo_blue_light));
                    colorLst1.add(new CustomEvent(android.R.color.holo_purple));
                    return colorLst1;
                }
                if(year==2015 && month == 7 && day == 5){
                    List<CustomEvent> colorLst1 = new ArrayList<>();
                    colorLst1.add(new CustomEvent(android.R.color.holo_purple));
                    return colorLst1;
                }
                return null;
            }
        });
    }

    @Override
    public void onDateClick(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year,month,day);
        // Toast.makeText(this,cal.getTime().toString()+ " Clicked",Toast.LENGTH_SHORT).show();
    }
}
