package com.example.bohdan.myorganizermain;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bohdan.myorganizermain.database.EventRealmObject;
import com.example.bohdan.myorganizermain.database.RealmHelper;
import com.example.bohdan.myorganizermain.models.EventDetailItem;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventDetailsFragment extends Fragment implements View.OnClickListener {
    private ArrayList<EventDetailItem> eventDetailItems = new ArrayList<>();
    private RecyclerView recyclerViewEvents;
    private RecyclerViewEventsAdapter recyclerViewEventsAdapter;
    private TextView tvGetMsg;
    private EditText edit;
    private Button butGetMsg;

    public EventDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event_details, container, false);

        initViews(view);
        initListOfEvents();

        return view;
    }

    private void initListOfEvents() {
        RealmHelper realmHelper = new RealmHelper(getActivity());
        if (eventDetailItems != null) {
            eventDetailItems.clear();
        }

        for (EventRealmObject event : realmHelper.getAllEvents()) {
            EventDetailItem eventDetailItem = new EventDetailItem(event.getEventName(), event.getTimeFrom(), event.getTimeTo(),
                    event.getYear(), event.getMonth(), event.getDay());

            eventDetailItems.add(eventDetailItem);
        }
    }

    private void initViews(View view) {
        recyclerViewEvents = (RecyclerView) view.findViewById(R.id.recycler_view_events);
        recyclerViewEvents.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerViewEventsAdapter = new RecyclerViewEventsAdapter(getActivity(), eventDetailItems, new RecyclerViewEventsAdapter.EventItemListener() {
            @Override
            public void onClick(EventDetailItem eventDetailItem) {
                handleEventClick(eventDetailItem);
            }
        });
        recyclerViewEvents.setAdapter(recyclerViewEventsAdapter);

        tvGetMsg = (TextView) view.findViewById(R.id.tvGetMessage);
        edit = (EditText) view.findViewById(R.id.editText);
        butGetMsg = (Button) view.findViewById(R.id.butGetText);

        butGetMsg.setOnClickListener(this);
    }

    private void handleEventClick(EventDetailItem eventDetailItem) {
        Toast.makeText(getActivity(), "Event was clicked!!!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();


    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        tvGetMsg.setText(edit.getText());
    }
}

