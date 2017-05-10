package com.nativeview.testpackage;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.nativeview.R;


public class TestView extends RelativeLayout {

    private ThemedReactContext mContext;
    private RCTEventEmitter mEventEmitter;
    public static final String TAG = "TestView";

    private void inflateLayout(Context context) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.test_container, this);

    }


    public TestView(ThemedReactContext context, AttributeSet attrs) {
        super(context);
        Log.d(TAG, "TestView constructor");

        //setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));


        mContext = context;
        mEventEmitter = mContext.getJSModule(RCTEventEmitter.class);

        inflateLayout(context);
    }

    /*public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.test_container, container, false);
    }*/

}

