package com.example.bohdan.myorganizermain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bohdan.myorganizermain.activity.AddNewEventActivity;
import com.example.bohdan.myorganizermain.database.EventRealmObject;
import com.example.bohdan.myorganizermain.database.RealmHelper;
import com.example.bohdan.myorganizermain.models.EventDetailItem;
import com.p_v.flexiblecalendar.FlexibleCalendarView;
import com.p_v.flexiblecalendar.entity.Event;
import com.p_v.flexiblecalendar.view.BaseCellView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by irkap on 30.10.2016.
 */

public class CalendarHelper implements FlexibleCalendarView.OnDateClickListener {
    private FlexibleCalendarView flexibleCalendarView;
    private Toolbar toolbar;
    private AppCompatActivity activity;
    private TextView txtMonthName;

    private ArrayList<EventDetailItem> eventDetailItems = new ArrayList<>();
    private Calendar selectedDay;


    public CalendarHelper(AppCompatActivity activity, FlexibleCalendarView flexibleCalendarView, TextView txtMonthName) {
        this.activity = activity;
        this.flexibleCalendarView = flexibleCalendarView;
        this.txtMonthName = txtMonthName;

        initCalendar();
    }


    private void initCalendar() {
        initMonthName();

        initEventsList();

        flexibleCalendarView.setOnDateClickListener(this);
        flexibleCalendarView.setOnMonthChangeListener(new FlexibleCalendarView.OnMonthChangeListener() {
            @Override
            public void onMonthChange(int year, int month, int direction) {
                Calendar cal = Calendar.getInstance();
                cal.set(year, month, 1);

                String monthName = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
                txtMonthName.setText(monthName);
                //  Toast.makeText(activity, cal.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.ENGLISH) + " " + year, Toast.LENGTH_SHORT).show();
            }
        });
        flexibleCalendarView.setCalendarView(new FlexibleCalendarView.CalendarView() {
            @Override
            public BaseCellView getCellView(int position, View convertView, ViewGroup parent, int cellType) {
                BaseCellView cellView = (BaseCellView) convertView;
                if (cellView == null) {
                    LayoutInflater inflater = LayoutInflater.from(activity);
                    cellView = (BaseCellView) inflater.inflate(R.layout.cell_view, null);
                }
                if (cellType == BaseCellView.TODAY) {
                    cellView.setTextColor(activity.getResources().getColor(android.R.color.holo_red_dark));
                    cellView.setTextSize(20);
                } else {
                    cellView.setTextColor(activity.getResources().getColor(android.R.color.black));
                    cellView.setTextSize(20);
                }
                return cellView;
            }

            @Override
            public BaseCellView getWeekdayCellView(int position, View convertView, ViewGroup parent) {
                BaseCellView cellView = (BaseCellView) convertView;
                if (cellView == null) {
                    LayoutInflater inflater;
                    inflater = LayoutInflater.from(activity);
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

                int count = 0;
                for (EventDetailItem event : eventDetailItems) {

                    if (event.getYear() == year && event.getMonth() - 1 == month && event.getDay() == day) {
                        count++;

                    }

                }


                List<CustomEvent> colorLst1 = new ArrayList<>();
                for (int i = 0; i < count; i++) {

                    colorLst1.add(new CustomEvent(android.R.color.holo_red_dark));
                }

                return colorLst1;


               /* if (year == 2017 && month == 1 && day == 1) {
                    List<CustomEvent> colorLst1 = new ArrayList<>();
                    colorLst1.add(new CustomEvent(android.R.color.holo_green_dark));
                    colorLst1.add(new CustomEvent(android.R.color.holo_blue_light));
                    colorLst1.add(new CustomEvent(android.R.color.holo_purple));
                    return colorLst1;

                }*//*
                if (year == 2016 && month == 8 && day == 8) {
                    List<CustomEvent> colorLst1 = new ArrayList<>();
                    colorLst1.add(new CustomEvent(android.R.color.holo_green_dark));
                    colorLst1.add(new CustomEvent(android.R.color.holo_blue_light));
                    colorLst1.add(new CustomEvent(android.R.color.holo_purple));
                    return colorLst1;
                }
                if (year == 2015 && month == 7 && day == 5) {
                    List<CustomEvent> colorLst1 = new ArrayList<>();
                    colorLst1.add(new CustomEvent(android.R.color.holo_purple));
                    return colorLst1;
                }*/

            }
        });
    }

    private void initEventsList() {
        RealmHelper realmHelper = new RealmHelper(activity);
        for (EventRealmObject event : realmHelper.getAllEvents()) {
            EventDetailItem eventDetailItem = new EventDetailItem(event.getEventName(), event.getTimeFrom(), event.getTimeTo(),
                    event.getYear(), event.getMonth(), event.getDay());

            eventDetailItems.add(eventDetailItem);
        }
    }

    private void initMonthName() {
        Calendar cal = Calendar.getInstance();

        String monthName = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
        txtMonthName.setText(monthName);
    }

    @Override
    public void onDateClick(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);


        selectedDay = cal;
        // Toast.makeText(this,cal.getTime().toString()+ " Clicked",Toast.LENGTH_SHORT).show();


    }

    public void notifyItems(){
        initCalendar();
    }

    public Calendar getSelectedCalendar() {

        return selectedDay;
    }
}
