package com.example.bohdan.myorganizermain.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bohdan.myorganizermain.R;
import com.example.bohdan.myorganizermain.database.EventRealmObject;
import com.example.bohdan.myorganizermain.database.RealmHelper;

public class AddNewEventActivity extends AppCompatActivity {
    private EditText eventName;
    private EditText eventTo;
    private EditText eventFrom;
    private Button btnSave;
    private Toolbar toolbar;


    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_event);

        year = getIntent().getIntExtra("year", 0);
        month = getIntent().getIntExtra("month", 0);
        day = getIntent().getIntExtra("day", 0);


        initViews();
    }

    private void initViews() {
        eventName = (EditText) findViewById(R.id.event_name);
        eventFrom = (EditText) findViewById(R.id.event_from);
        eventTo = (EditText) findViewById(R.id.event_to);
        btnSave = (Button) findViewById(R.id.btn_save);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("New event");

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateFields()) {

                    EventRealmObject eventRealmObject = new EventRealmObject();

                    eventRealmObject.setEventName(eventName.getText().toString());
                    eventRealmObject.setTimeFrom(eventFrom.getText().toString());
                    eventRealmObject.setTimeTo(eventTo.getText().toString());
                    eventRealmObject.setYear(year);
                    eventRealmObject.setMonth(month);
                    eventRealmObject.setDay(day);

                    RealmHelper realmHelper = new RealmHelper(AddNewEventActivity.this);
                    realmHelper.addNewEventToDatabase(eventRealmObject);

                    Toast.makeText(AddNewEventActivity.this, "New event was added successfully ", Toast.LENGTH_LONG);
                    AddNewEventActivity.this.finish();
                }
            }
        });
    }

    private boolean validateFields() {
        boolean isValid = true;

        if (eventName.getText().toString().trim().equals("")) {
            isValid = false;
        }
        if (eventFrom.getText().toString().trim().equals("")) {
            isValid = false;
        }
        if (eventTo.getText().toString().trim().equals("")) {
            isValid = false;
        }

        if (!isValid) {
            Toast.makeText(this, "Type all fields correctly!", Toast.LENGTH_LONG).show();
        }

        return isValid;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
