package com.webridge.GeekQuote.model;

import java.util.Date;

/**
 * Created by Thomas on 9/1/2014.
 */
public class Quote {

    private String strQuote;
    private int rating;
    private Date creationDate;

    public String getStrQuote() {
        return strQuote;
    }

    public void setStrQuote(String strQuote) {
        this.strQuote = strQuote;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
