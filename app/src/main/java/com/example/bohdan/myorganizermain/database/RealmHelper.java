package com.example.bohdan.myorganizermain.database;

import android.content.Context;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by bohdan on 03.12.16.
 */

public class RealmHelper {
    private Context context;

    public RealmHelper(Context context) {
        this.context = context;
    }

    public void addNewEventToDatabase(EventRealmObject objectForSaving) {

        // Obtain a Realm instance
        Realm realm = Realm.getInstance(context);

        realm.beginTransaction();

        EventRealmObject newEvent = realm.createObject(EventRealmObject.class); // Create a new object

        newEvent.setEventName(objectForSaving.getEventName());
        newEvent.setTimeFrom(objectForSaving.getTimeFrom());
        newEvent.setTimeTo(objectForSaving.getTimeTo());

        newEvent.setYear(objectForSaving.getYear());
        newEvent.setMonth(objectForSaving.getMonth());
        newEvent.setDay(objectForSaving.getDay());

        realm.commitTransaction();
    }

    public ArrayList<EventRealmObject> getAllEvents(){
        ArrayList<EventRealmObject> eventRealmObjectArrayList = new ArrayList<>();

        Realm realm = Realm.getInstance(context);
        RealmResults<EventRealmObject> result = realm.where(EventRealmObject.class).findAll();

        for (EventRealmObject event : result){
            eventRealmObjectArrayList.add(event);
        }


        return eventRealmObjectArrayList;
    }
}
