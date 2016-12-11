package com.example.bohdan.myorganizermain.database;

import io.realm.RealmObject;

/**
 * Created by bohdan on 03.12.16.
 */

public class EventRealmObject extends RealmObject {

    private String eventName;
    private String timeFrom;
    private String timeTo;
    private int year;
    private int month;
    private int day;

    public EventRealmObject() {

    }



    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(String timeFrom) {
        this.timeFrom = timeFrom;
    }

    public String getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(String timeTo) {
        this.timeTo = timeTo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
