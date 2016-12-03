package com.example.bohdan.myorganizermain.models;

/**
 * Created by bohdan on 17.11.16.
 */

public class EventDetailItem {
    private String name, timeFrom, timeTo;
    private int year, month, day;

    public EventDetailItem(String name, String timeFrom, String timeTo, int year, int month, int day) {
        this.name = name;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
