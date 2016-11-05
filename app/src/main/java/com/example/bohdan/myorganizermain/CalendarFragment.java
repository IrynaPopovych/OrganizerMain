package com.example.bohdan.myorganizermain;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.p_v.flexiblecalendar.FlexibleCalendarView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalendarFragment extends Fragment {
    private View fragmentView;
    private CalendarHelper calendarHelper;


    public CalendarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         fragmentView = inflater.inflate(R.layout.fragment_calendar, container, false);

        initCalendar();
        return fragmentView;
    }


    private void initCalendar() {
        calendarHelper = new CalendarHelper((AppCompatActivity) getActivity(),
                (FlexibleCalendarView) fragmentView.findViewById(R.id.flexible_calendar),
                (TextView) fragmentView.findViewById(R.id.month_name));
    }
}
