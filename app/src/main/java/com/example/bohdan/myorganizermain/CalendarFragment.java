package com.example.bohdan.myorganizermain;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bohdan.myorganizermain.activity.AddNewEventActivity;
import com.p_v.flexiblecalendar.FlexibleCalendarView;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalendarFragment extends Fragment {
    private View fragmentView;
    private CalendarHelper calendarHelper;

    private Button btnAddNewEvent;

    public CalendarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentView = inflater.inflate(R.layout.fragment_calendar, container, false);

        initViews();

        initCalendar();
        return fragmentView;
    }

    private void initViews() {

        btnAddNewEvent = (Button) fragmentView.findViewById(R.id.btn_add_new_event);
        btnAddNewEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar selectedDay = calendarHelper.getSelectedCalendar();
                if (selectedDay == null) {
                    Toast.makeText(getActivity(), "Please, select the day", Toast.LENGTH_LONG).show();
                } else {

                    int year = selectedDay.get(Calendar.YEAR);
                    int month = selectedDay.get(Calendar.MONTH);
                    month++;
                    int day = selectedDay.get(Calendar.DAY_OF_MONTH);

                    Intent intent = new Intent(getActivity(), AddNewEventActivity.class);
                    intent.putExtra("year", year);
                    intent.putExtra("month", month);
                    intent.putExtra("day", day);
                    startActivity(intent);
                }

            }
        });
    }


    private void initCalendar() {
        calendarHelper = new CalendarHelper((AppCompatActivity) getActivity(),
                (FlexibleCalendarView) fragmentView.findViewById(R.id.flexible_calendar),
                (TextView) fragmentView.findViewById(R.id.month_name));
    }


}
