package com.webridge.GeekQuote;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import com.webridge.GeekQuote.model.Quote;
import org.w3c.dom.Text;

/**
 * Created by Thomas on 9/2/2014.
 */
public class QuoteActivity extends Activity {

    private Quote quote;
    private int quoteIndex;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quote);

        Intent intent = getIntent();
        quote = (Quote)intent.getSerializableExtra("quoteValue");
        quoteIndex = intent.getIntExtra("quoteIndex", -1);

        // Getting components
        final TextView quoteTextView = (TextView) findViewById(R.id.quoteText);
        TextView quoteDateView = (TextView) findViewById(R.id.quoteDate);
        final RatingBar quoteRateView = (RatingBar) findViewById(R.id.quoteRate);

        // Setting quote content
        quoteTextView.setText(quote.getStrQuote());
        quoteDateView.setText(quote.getCreationDate().toString());
        quoteRateView.setRating(quote.getRating());


        // Setting the edit function
        quoteTextView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                final Dialog editDialog = new Dialog(view.getContext());
                editDialog.setContentView(
                        R.layout.quote_edit
                );
                editDialog.setTitle(R.string.edit_quote_title);

                Button editOkBtn = (Button)editDialog.findViewById(R.id.editOkBtn);
                final Button editCancelBtn = (Button)editDialog.findViewById(R.id.editCancelBtn);
                final EditText editTextView = (EditText)editDialog.findViewById(R.id.editQuoteText);

                editCancelBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        editTextView.setText("");
                        editDialog.hide();
                    }
                });
                editOkBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String strQuote = editTextView.getText().toString();
                        // Let's not allow an empty text
                        if(strQuote.isEmpty()) return;

                        quote.setStrQuote(strQuote);
                        quoteTextView.setText(strQuote);

                        editTextView.setText("");
                        editDialog.hide();
                    }
                });
                editTextView.setText(quote.getStrQuote());
                editDialog.getWindow().setLayout(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
                editDialog.show();
                return false;
            }
        });
        quoteRateView.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                quote.setRating(v);
            }
        });
    }

    /**
     * Finishes the activity with a fail result.
     * This is called when the Cancel Button is clicked (see layout onClick attribute)
     * @param v The view triggering the onClick event
     */
    public void onCancelButtonClicked(View v){
        setResult(RESULT_CANCELED);
        finish();
    }

    /**
     * Finishes the activity with a Success result.
     * This is called when the Ok Button is clicked (see layout onClick attribute)
     * @param v The view triggering the onClick event
     */
    public void onOkButtonClicked(View v){
        Intent intent = getIntent();
        intent.putExtra("quoteValue", quote);
        intent.putExtra("quoteIndex", quoteIndex);
        setResult(RESULT_OK, intent);
        finish();
    }
}