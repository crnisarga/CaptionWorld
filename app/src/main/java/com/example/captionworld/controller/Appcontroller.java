package com.example.captionworld.controller;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Appcontroller extends Application {
    // since it extends Application, hence it's life cycle will be throughout the whole App

    public static final String TAG = Appcontroller.class.getSimpleName();
    // TAG is used to determine which Activity has logged in information in the logcat

    private RequestQueue mRequestQueue;

    private static Appcontroller mInstance;
    // so that we have only one request queue & one image loader

    @Override
    public void onCreate() {
        super.onCreate(); // calling the constructor of the super class i.e Application is created
        /// before any service/Activity
        mInstance = this;
    }

    public static synchronized Appcontroller getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
            // setting up a new request queue
            // getApplicationContext() returns the context for the entire application ( the
            // processes all the Activities are running inside of).
        }
        // Volley works with disk based cache i.e it caches files directly into the hard disk in the
        // specified directory

        // if we make a request, volley goes through the cache. If there's a cache hit then it
        // returns with that request.
        // in case of a cache miss, it makes an HTTP call & parses the response
        // & put that entry into the cache

        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
        // if we make a request, volley goes through the cache. If there's a cache hit then it
        // returns with that request.
        // in case of a cache miss, it makes an HTTP call & parses the response
        // & put that entry into the cache
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
