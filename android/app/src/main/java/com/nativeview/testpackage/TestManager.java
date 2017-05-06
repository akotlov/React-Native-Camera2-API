package com.nativeview.testpackage;

import android.view.View;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;


public class TestManager extends SimpleViewManager<TestView> {
    public static final String REACT_CLASS = "Test";
    private static final String TAG = "Test";


    @Override
    public String getName() {
        // Tell React the name of the module
        return REACT_CLASS;
    }

    @Override
    public TestView createViewInstance(ThemedReactContext context){

        TestView view = new TestView(context, null);
        //ProgressBar progressBar = new ProgressBar(context);

        //context.getCurrentActivity().setContentView(view);


        return view;


    }

    @ReactProp(name = "exampleProp")
    public void setExampleProp(View view, String prop) {
        // Set properties from React onto your native component
        // https://facebook.github.io/react-native/docs/native-components-android.html#3-expose-view-property-setters-using-reactprop-or-reactpropgroup-annotation
    }
}
