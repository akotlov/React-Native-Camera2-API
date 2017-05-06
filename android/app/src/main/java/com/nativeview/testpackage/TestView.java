package com.nativeview.testpackage;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.nativeview.R;


public class TestView extends RelativeLayout implements LifecycleEventListener {

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

        mContext = context;
        mEventEmitter = mContext.getJSModule(RCTEventEmitter.class);
        mContext.addLifecycleEventListener(this);

        inflateLayout(context);


        /*ScrollView sv = new ScrollView(context);
        LinearLayout ll = new LinearLayout(context);
        ll.setOrientation(LinearLayout.VERTICAL);
        sv.addView(ll);
        TextView tv = new TextView(context);
        tv.setText("Dynamic layouts ftw!");
        ll.addView(tv);
        EditText et = new EditText(context);
        et.setText("weeeeeeeeeee~!");
        ll.addView(et);
        Button b = new Button(context);
        b.setText("I don't do anything, but I was added dynamically. :)");

        ll.addView(b);

        for(int i = 0; i < 20; i++) {

            CheckBox cb = new CheckBox(context);

            cb.setText("I'm dynamic!");

            ll.addView(cb);
        }*/


    }

    @Override
    public void onHostPause() {

    }

    @Override
    public void onHostResume() {

    }

    @Override
    public void onHostDestroy() {
    }
}

