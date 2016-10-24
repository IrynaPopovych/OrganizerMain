package com.example.bohdan.myorganizermain;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.p_v.flexiblecalendar.view.CircularEventCellView;

/**
 * Created by bohdan on 20.10.16.
 */
public class ExampleCellView extends CircularEventCellView {

    public ExampleCellView(Context context) {
        super(context);
    }

    public ExampleCellView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExampleCellView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = (7*width)/8;
        heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
    }
}

