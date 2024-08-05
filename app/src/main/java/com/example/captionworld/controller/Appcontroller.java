package com.example.captionworld.controller;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Appcontroller extends Application {
    public static final String TAG = Appcontroller.class.getSimpleName();
    private static Appcontroller mInstance;
    private RequestQueue mRequestQueue;

    public static synchronized Appcontroller getInstance() {return mInstance;}

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }
}
