package com.example.captionworld.data;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.captionworld.controller.Appcontroller;
import com.example.captionworld.modal.Quote;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class QuoteData {

    ArrayList<Quote> quotearray = new ArrayList<>();

    public void getQuote() {
        Log.d("myTag","the meothod is called");
        String url = "https://raw.github.com/pdichone/UIUX-Android-Course/blob/master/Quotes.json%20";
        url = url.replaceAll(" ", "%20");
        Log.d("myTag","the url is validated");
       JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                Log.d("myTag", "hello this main entered is here");
                 for (int i = 0; i < response.length(); i++) {
                     Log.d("myTag", "entered the loop also");
                     try {
                         Log.d("myTag", "hello this comtrol is here");
                         JSONObject quoteObject = response.getJSONObject(i);
                         Quote quote = new Quote();
                         quote.setQuote(quoteObject.getString("quote"));
                         quote.setName(quoteObject.getString("name"));

                         quotearray.add(quote);

                     } catch (JSONException e) {
                         e.printStackTrace();
                     }
                 }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    //This indicates that the reuest has either time out or there is no connection

                } else if (error instanceof AuthFailureError) {
                    // Error indicating that there was an Authentication Failure while performing the request

                } else if (error instanceof ServerError) {
                    //Indicates that the server responded with a error response

                } else if (error instanceof NetworkError) {
                    //Indicates that there was network error while performing the request

                } else if (error instanceof ParseError) {
                    // Indicates that the server response could not be parsed

                }
            }
        });
        Appcontroller.getInstance().addToRequestQueue(jsonArrayRequest);
    }
}
