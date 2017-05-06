//  Created by react-native-create-bridge

package com.nativeview.camera2;

import android.Manifest;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.anthonycr.grant.PermissionsManager;
import com.anthonycr.grant.PermissionsResultAction;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.nativeview.R;


public class Camera2Manager extends SimpleViewManager<RelativeLayout> {
    public static final String REACT_CLASS = "Camera2";
    private static final String TAG = "Camera2VideoFragment";

    private static final int COMMAND_RECORD = 559;
    private static final int COMMAND_STOP = 365;

    @Override
    public String getName() {
        // Tell React the name of the module
        // https://facebook.github.io/react-native/docs/native-components-android.html#1-create-the-viewmanager-subclass
        return REACT_CLASS;
    }

    @Override
    public RelativeLayout createViewInstance(ThemedReactContext context){
        // Create a view here

        RelativeLayout view = new RelativeLayout(context);

        //view.setId(View.generateViewId());

        //A Fragment must always be embedded in an Activity.

        /*FragmentManager fragmentManager = context.getCurrentActivity().getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Camera2VideoView fragment = new Camera2VideoView();
        fragmentTransaction.add(view.getId(), fragment);
        fragmentTransaction.commit();

        return view;*/

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

        context.getCurrentActivity().setContentView(R.layout.container);

        context.getCurrentActivity().getFragmentManager().beginTransaction()
                .replace(R.id.container, new Camera2VideoView())
                .commit();

        return  view;

    }

    @ReactProp(name = "exampleProp")
    public void setExampleProp(View view, String prop) {
        // Set properties from React onto your native component
        // https://facebook.github.io/react-native/docs/native-components-android.html#3-expose-view-property-setters-using-reactprop-or-reactpropgroup-annotation
    }

    /*
    @Override
    public @Nullable
    Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of(
                "recordingStart", MapBuilder.of("registrationName", "onRecordingStarted"),
                "recordingFinish", MapBuilder.of("registrationName", "onRecordingFinished"),
                "cameraAccessException", MapBuilder.of("registrationName", "onCameraAccessException"),
                "cameraFailed", MapBuilder.of("registrationName", "cameraFailed")
        );
    }

    @Override
    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of(
                "record", COMMAND_RECORD,
                "stop", COMMAND_STOP
        );
    }

    @Override
    public void receiveCommand(
            RelativeLayout view,
            int commandType,
            @Nullable ReadableArray args
    ) {
        Assertions.assertNotNull(view);

        switch (commandType) {
            case COMMAND_RECORD:
                view.record();
                break;
            case COMMAND_STOP:
                view.stop();
        }
    }*/
}
