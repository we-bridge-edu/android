package com.webridge.GeekQuote;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import com.webridge.GeekQuote.model.Quote;

import java.util.ArrayList;
import java.util.Date;

public class QuoteListActivity extends Activity {

    private ArrayList<Quote> quotes = new ArrayList<Quote>();
    private ArrayAdapter<Quote> quotesAdapter;
    private Resources res;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Creating the Array Adapter
        quotesAdapter = new ArrayAdapter<Quote>(
                this,
                android.R.layout.simple_list_item_1,
                quotes
        ){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // We override the adapter to alternate the row colors
                TextView view = (TextView)super.getView(position, convertView, parent);
                if(position % 2 == 0)
                    view.setBackgroundColor(
                            res.getColor(R.color.quoteDarkerBackground)
                    );
                else
                    view.setBackgroundColor(Color.BLACK);

                // We aren't using the quote toString method anymore
                // instead we set the text manually
                Quote quote = getItem(position);
                view.setText(quote.getStrQuote());

                return view;
            }
        };
        quotesAdapter.setNotifyOnChange(true);

        // Setting the array adapter
        final ListView quotesView = (ListView) findViewById(
                R.id.quotesView
        );
        quotesView.setAdapter(quotesAdapter);

        // Setting the button event listener
        Button addQuoteBtn = (Button) findViewById(R.id.addQuoteBtn);
        addQuoteBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText textView =
                                (EditText) findViewById(R.id.addQuoteText);

                        // Get the text from the text field
                        String text = textView.getText().toString();

                        // If the field is empty, do not add an empty quote
                        if(text.isEmpty()) return;

                        // Add the quote to the list
                        addQuote(text);

                        // Reset the text field
                        textView.setText("");

                        // Close the soft keyboard after adding a quote
                        textView.clearFocus();
                        InputMethodManager input = (InputMethodManager) getSystemService(
                                Context.INPUT_METHOD_SERVICE
                        );
                        input.hideSoftInputFromWindow(textView.getWindowToken(), 0);
                    }
                }
        );

        // Getting the quotes from the resources
        res = getResources();
        String[] strQuotes = res.getStringArray(R.array.quotes);

        // Clear the quotes and add from the resources
        quotes.clear();
        for (String strQuote : strQuotes) {
            addQuote(strQuote);
        }

    }

    /**
     * Adds a quote to the activity list of quotes.
     *
     * @param strQuote The test of the quote
     */
    void addQuote(String strQuote) {
        // Create the quote object
        Quote quote = new Quote();

        // Set the text of the quote
        quote.setStrQuote(strQuote);
        // Default Date is now
        quote.setCreationDate(new Date());

        // Add the quote to the list of quotes
        quotesAdapter.add(quote);
    }
}
