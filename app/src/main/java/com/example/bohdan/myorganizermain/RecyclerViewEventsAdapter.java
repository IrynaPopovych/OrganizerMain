package com.example.bohdan.myorganizermain;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.bohdan.myorganizermain.models.EventDetailItem;

import java.util.ArrayList;

/**
 * Created by bohdan on 17.11.16.
 */

public class RecyclerViewEventsAdapter extends RecyclerView.Adapter<RecyclerViewEventsAdapter.EventViewHolder> {
    private Context context;
    private ArrayList<EventDetailItem> eventDetailItems = new ArrayList<>();
    private EventItemListener eventItemListener;

    public RecyclerViewEventsAdapter(Context context, ArrayList<EventDetailItem> eventDetailItems, EventItemListener eventItemListener) {
        this.context = context;
        this.eventDetailItems = eventDetailItems;
        this.eventItemListener = eventItemListener;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.event_item, parent, false);
        EventViewHolder eventViewHolder = new EventViewHolder(view);
        return eventViewHolder;
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        final EventDetailItem eventDetailItem = eventDetailItems.get(position);
        holder.itemContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventItemListener.onClick(eventDetailItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return eventDetailItems.size();
    }

    class EventViewHolder extends RecyclerView.ViewHolder {
        LinearLayout itemContainer;

        public EventViewHolder(View itemView) {
            super(itemView);
            itemContainer = (LinearLayout) itemView.findViewById(R.id.item_container);
        }
    }

    public interface EventItemListener {
        void onClick(EventDetailItem eventDetailItem);
    }
}
