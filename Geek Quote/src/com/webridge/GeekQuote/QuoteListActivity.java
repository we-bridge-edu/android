package com.webridge.GeekQuote;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.webridge.GeekQuote.model.Quote;

import java.util.ArrayList;
import java.util.Date;

public class QuoteListActivity extends Activity {

    private ArrayList<Quote> quotes = new ArrayList<Quote>();
    private Resources res;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Getting the quotes from the resources
        res = getResources();
        String[] strQuotes = res.getStringArray(R.array.quotes);

        // Clear the quotes and add from the resources
        quotes.clear();
        for(String strQuote : strQuotes){
            addQuote(strQuote);
        }

    }

    /**
     * Adds a quote to the activity list of quotes.
     * @param strQuote The test of the quote
     */
    void addQuote(String strQuote){
        // Create the quote object
        Quote quote = new Quote();

        // Set the text of the quote
        quote.setStrQuote(strQuote);
        // Default Date is now
        quote.setCreationDate(new Date());

        // Add the quote to the list of quotes
        quotes.add(quote);

        // Create a Text view representing the quote
        TextView quoteView = new TextView(this);
        quoteView.setText(strQuote);

        if(quotes.size() % 2 == 0)
            quoteView.setBackgroundColor(
                    res.getColor(R.color.quoteDarkerBackground)
            );

        LinearLayout quotesView = (LinearLayout) findViewById(
                R.id.quotesView
            );
        quotesView.addView(quoteView);
    }
}
