package com.example.captionworld.data;

import com.example.captionworld.modal.Quote;

import java.util.ArrayList;

public interface QuoteListAsyncResponse {
    void processeFinished(ArrayList<Quote> quotes);
}
