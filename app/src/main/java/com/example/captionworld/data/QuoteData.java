package com.example.captionworld.data;

import com.android.volley.Request;
import com.android.volley.Response;
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
        String url = "https://github.com/crnisarga/CaptionWorld/blob/master/Caption.txt";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                 for (int i = 0; i < response.length(); i++) {
                     try {
                         JSONObject quoteObject = response.getJSONObject(i);
                         Quote quote = new Quote();
                         quote.setQuote(quoteObject.getString("quote"));
                         quote.setScenario(quoteObject.getString("name"));
                     } catch (JSONException e) {
                         throw new RuntimeException(e);
                     }
                 }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Appcontroller.getInstance().addToRequestQueue(jsonArrayRequest);
    }
}
