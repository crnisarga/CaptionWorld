package com.example.captionworld;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.captionworld.data.QuoteData;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new QuoteData().getQuote();
    }
}
