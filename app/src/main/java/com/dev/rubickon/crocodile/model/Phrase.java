package com.dev.rubickon.crocodile.model;

import com.dev.rubickon.crocodile.screen.common.ListItem;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by DNS1 on 10.07.2017.
 */

public class Phrase implements ListItem {

    @SerializedName("id")
    private long id;
    @SerializedName("phrase")
    private String phrase;
    @SerializedName("level")
    private String level;
    @SerializedName("rate")
    private String rate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
