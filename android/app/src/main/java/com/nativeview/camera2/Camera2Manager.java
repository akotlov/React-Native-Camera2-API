//  Created by react-native-create-bridge

package com.nativeview.camera2;

import android.Manifest;
import android.util.Log;
import android.view.View;

import com.anthonycr.grant.PermissionsManager;
import com.anthonycr.grant.PermissionsResultAction;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.Map;

import javax.annotation.Nullable;


public class Camera2Manager extends SimpleViewManager<Camera2VideoView>  {
    public static final String REACT_CLASS = "Camera2";
    private static final String TAG = "Camera2Manager";


    /*@Override
    public void onHostResume() {
        Log.d(TAG, "onHostResume");
        view.onResume();
    }

    @Override
    public void onHostPause() {
        Log.d(TAG, "onHostPause");
        view.onPause();
    }

    @Override
    public void onHostDestroy() {
        Log.d(TAG, "onHostDestroy");

    }*/

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public Camera2VideoView createViewInstance(ThemedReactContext context){

        final Camera2VideoView view = new Camera2VideoView(context ,context.getCurrentActivity());
        //final Camera2VideoView view = new Camera2VideoView(context.getBaseContext() ,context.getCurrentActivity());

        final LifecycleEventListener listener = new LifecycleEventListener() {
            @Override
            public void onHostResume() {
                Log.d(TAG, "onHostResume");
                view.onResume();
            }

            @Override
            public void onHostPause() {
                Log.d(TAG, "onHostPause");
                view.onPause();
            }

            @Override
            public void onHostDestroy() {
                Log.d(TAG, "onHostDestroy");
                /*if (listener != null && context != null) {
                    context.removeLifecycleEventListener(listener);
                    listener = null;
                }*/
            }
        };
        context.addLifecycleEventListener(listener);

        //RelativeLayout view = new RelativeLayout(context);
        //A Fragment must always be embedded in an Activity.
        // Requesting all the permissions in the manifest
        PermissionsManager.getInstance().requestAllManifestPermissionsIfNecessary(context.getCurrentActivity(), new PermissionsResultAction() {
            @Override
            public void onGranted() {
                //Toast.makeText(context.getCurrentActivity(), R.string.message_granted, Toast.LENGTH_SHORT).show();
                //writeToStorage("Hello, World!")
                Log.d(TAG, "Permission granted");

            }

            @Override
            public void onDenied(String permission) {
                //String message = String.format(Locale.getDefault(), context.getCurrentActivity().getString(R.string.message_denied), permission);
                //Toast.makeText(context.getCurrentActivity(), message, Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Permission denied");
            }
        });

        boolean hasPermission = PermissionsManager.getInstance().hasPermission(context.getCurrentActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        Log.d(TAG, "Has " + Manifest.permission.WRITE_EXTERNAL_STORAGE + " permission: " + hasPermission);

        /*context.getCurrentActivity().setContentView(R.layout.container);

        context.getCurrentActivity().getFragmentManager().beginTransaction()
                .replace(R.id.container, new Camera2VideoView())
                .commit();*/

        //context.getBaseContext(); current activity context.


        //view.onResume();
        return view;

    }

    @Override
    public @Nullable Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of(
                "recordingStart", MapBuilder.of("registrationName", "onRecordingStarted"),
                "recordingFinish", MapBuilder.of("registrationName", "onRecordingFinished")
                //"cameraAccessException", MapBuilder.of("registrationName", "onCameraAccessException"),
                //"cameraFailed", MapBuilder.of("registrationName", "cameraFailed")
        );
    }

    @ReactProp(name = "exampleProp")
    public void setExampleProp(View view, String prop) {
        // Set properties from React onto your native component
        // https://facebook.github.io/react-native/docs/native-components-android.html#3-expose-view-property-setters-using-reactprop-or-reactpropgroup-annotation
    }
}


/*
from https://github.com/airbnb/react-native-maps/blob/master/lib/android/src/main/java/com/airbnb/android/react/maps/AirMapView.java  LINE:340
-Maybe to use in onHostDestroy()

public synchronized  void doDestroy() {
        if (destroyed) {
            return;
        }
        destroyed = true;

        if (lifecycleListener != null && context != null) {
            context.removeLifecycleEventListener(lifecycleListener);
            lifecycleListener = null;
        }
        if (!paused) {
            onPause();
            paused = true;
        }
        onDestroy();
    }

 */

//Changes:
/*
removed android:layout_below="@id/texture" from main.xml.Seems like RN view hierarchy "overrides" Android hierarhy.




NOTES:
Since an activity can only use a single View as content view, it is common to use a ViewGroup as content view.
A ViewGroup is a subclass of View. A ViewGroup can contain multiple View inside it, so using a ViewGroup as content
view enables your view to consist of multiple View instances.

All Views have four constructors (it is depends of a API Level) and all have public access But all of them have
specific goal and specification where should be used




 */
