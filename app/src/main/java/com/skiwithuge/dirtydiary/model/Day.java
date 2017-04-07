package com.skiwithuge.dirtydiary.model;

/**
 * Created by skiwithuge on 4/3/17.
 */

public class Day {

    private long id;
    private long date;
    private String title;
    private String content;

    public Day(long id, long date, String title, String content) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public long getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
