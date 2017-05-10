//  Created by react-native-create-bridge

package com.nativeview.videorecorder;

import android.Manifest;
import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.anthonycr.grant.PermissionsManager;
import com.anthonycr.grant.PermissionsResultAction;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;


public class VideoRecorderManager extends SimpleViewManager<VideoRecorderBase> implements LifecycleEventListener {
    public static final String REACT_CLASS = "VideoRecorder";
    private static final String TAG = "VideoRecorder";

    private Activity mActivity;
    private VideoRecorderBase mView;

    public VideoRecorderManager(Activity activity) {
        mActivity = activity;
    }

    @Override
    public void onHostResume() {
        mView.onResume();
    }

    @Override
    public void onHostPause() {
        mView.onPause();
    }

    @Override
    public void onHostDestroy() {

    }

    @Override
    public String getName() {
        // Tell React the name of the module
        return REACT_CLASS;
    }

    @Override
    public VideoRecorderBase createViewInstance(ThemedReactContext context){

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

        context.addLifecycleEventListener(this);
        mView = new VideoRecorderView(context, mActivity);

        return  mView;

    }

    @ReactProp(name = "exampleProp")
    public void setExampleProp(View view, String prop) {
        // Set properties from React onto your native component
        // https://facebook.github.io/react-native/docs/native-components-android.html#3-expose-view-property-setters-using-reactprop-or-reactpropgroup-annotation
    }

}
