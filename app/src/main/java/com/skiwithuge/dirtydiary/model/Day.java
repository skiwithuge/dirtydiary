package com.skiwithuge.dirtydiary.model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by skiwithuge on 4/3/17.
 */

public class Day {

    public UUID mId;
    public String mDate;
    public String mTitle;
    public String mContent;

    public Day(String date, String title, String content){
        mDate = date;
        mTitle = title;
        mContent = content;
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

}
