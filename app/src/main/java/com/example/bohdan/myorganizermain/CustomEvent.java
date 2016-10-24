package com.example.bohdan.myorganizermain;

import com.p_v.flexiblecalendar.entity.Event;

/**
 * Created by bohdan on 20.10.16.
 */
public class CustomEvent implements Event {

    private int color;

    public CustomEvent(int color) {
        this.color = color;
    }

    @Override
    public int getColor() {
        return color;
    }
}