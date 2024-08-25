package com.example.captionworld;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.captionworld.data.QuoteData;
import com.example.captionworld.data.QuoteListAsyncResponse;
import com.example.captionworld.data.QuoteViewPagerAdapter;
import com.example.captionworld.modal.Quote;

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

        new QuoteData().getQuote(new QuoteListAsyncResponse() {
            @Override
            public void processeFinished(ArrayList<Quote> quotes) {
                for (int i = 0; i < quotes.size(); i++) {
                    QuoteFragment quoteFragment = QuoteFragment.newInstance(
                            quotes.get(i).getQuote(),
                            quotes.get(i).getName()
                    );
                    fragmentList.add(quoteFragment);
                }

                quoteViewPagerAdapter.notifyDataSetChanged();
            }
        });
        return fragmentList;
    }
}
