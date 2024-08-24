package com.example.captionworld;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.captionworld.data.QuoteData;
import com.example.captionworld.data.QuoteViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private QuoteViewPagerAdapter quoteViewPagerAdapter;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quoteViewPagerAdapter = new QuoteViewPagerAdapter(getSupportFragmentManager(),getFragment());
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(quoteViewPagerAdapter);

    }

    private List<Fragment> getFragment() {
        List<Fragment> fragmentList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            QuoteFragment quoteFragment = QuoteFragment.newInstance("I am best","Nisarga");
            fragmentList.add(quoteFragment);
        }
        return fragmentList;
    }
}
