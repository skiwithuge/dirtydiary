package com.skiwithuge.dirtydiary.model;

/**
 * Created by skiwithuge on 4/3/17.
 */

public class Day {

    private String mDate;
    private String mTitle;
    private String mContent;

    public Day(String date, String title, String content) {
        mDate = date;
        mTitle = title;
        mContent = content;
    }

    public String getDate() {
        return mDate;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getContent() {
        return mContent;
    }
}
