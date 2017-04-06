package com.skiwithuge.dirtydiary.database;

public class DiaryDbSchema {
    public static class DayTable {
        public static final String TABLENAME = "day";

        public static final class Cols {
            public static final String ID = "id";
            public static final String DATE = "date";
            public static final String TITLE = "title";
            public static final String CONTENT = "content";
        }
    }
}