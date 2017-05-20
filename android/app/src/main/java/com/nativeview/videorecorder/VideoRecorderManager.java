//  Created by react-native-create-bridge

package com.nativeview.videorecorder;

import android.Manifest;
import android.util.Log;
import android.view.View;

import com.anthonycr.grant.PermissionsManager;
import com.anthonycr.grant.PermissionsResultAction;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;


public class VideoRecorderManager extends SimpleViewManager<VideoRecorderBase>  {
    public static final String REACT_CLASS = "VideoRecorder";
    private static final String TAG = "VideoRecorder";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public VideoRecorderBase createViewInstance(ThemedReactContext context){

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

        final VideoRecorderBase mView = new VideoRecorderView(context.getBaseContext() , context.getCurrentActivity());

        final LifecycleEventListener listener = new LifecycleEventListener() {
            @Override
            public void onHostResume() {
                Log.d(TAG, "onHostResume");
                mView.onResume();
            }

            @Override
            public void onHostPause() {
                Log.d(TAG, "onHostPause");
                mView.onPause();
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


        return mView;

    }

    @ReactProp(name = "exampleProp")
    public void setExampleProp(View view, String prop) {
        // Set properties from React onto your native component
        // https://facebook.github.io/react-native/docs/native-components-android.html#3-expose-view-property-setters-using-reactprop-or-reactpropgroup-annotation
    }

}
