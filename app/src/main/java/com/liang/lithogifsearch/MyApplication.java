package com.liang.lithogifsearch;

import android.app.Application;
import android.util.Log;

import com.facebook.soloader.SoLoader;

public class MyApplication extends Application {
    private static final String TAG = "MyApplication";
    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: starts");
        super.onCreate();
        SoLoader.init(this, false);
        Log.d(TAG, "onCreate: ends");
    }
}
