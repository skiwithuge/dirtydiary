package com.skiwithuge.dirtydiary.model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by skiwithuge on 4/3/17.
 */

public class Day {

    public UUID mId;
    public Date mDate;
    public String mTitle;
    public String mContent;


    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
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
