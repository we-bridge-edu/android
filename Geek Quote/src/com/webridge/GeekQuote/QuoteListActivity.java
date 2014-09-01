package com.webridge.GeekQuote;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Toast;
import com.webridge.GeekQuote.model.Quote;

import java.util.ArrayList;
import java.util.Date;

public class QuoteListActivity extends Activity {

    private ArrayList<Quote> quotes = new ArrayList<Quote>();

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Getting the quotes from the resources
        Resources res = getResources();
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

        // TODO: Remove when quotes are visible on UI
        Toast.makeText(getApplicationContext(), strQuote, Toast.LENGTH_SHORT)
                .show();
    }
}
