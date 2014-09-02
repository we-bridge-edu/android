package com.webridge.GeekQuote.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Thomas on 9/1/2014.
 */
public class Quote implements Serializable {

    private String strQuote;
    private float rating;
    private Date creationDate;

    public String getStrQuote() {
        return strQuote;
    }

    public void setStrQuote(String strQuote) {
        this.strQuote = strQuote;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return this.strQuote;
    }
}
