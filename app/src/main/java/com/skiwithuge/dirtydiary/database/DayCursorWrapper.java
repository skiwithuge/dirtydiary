package com.skiwithuge.dirtydiary.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.skiwithuge.dirtydiary.model.Day;

/**
 * Created by skiwithuge on 11/20/16.
 */

public class DayCursorWrapper extends CursorWrapper {

    public DayCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Day mapFromCursor() {
        long id = getLong(getColumnIndex(DayTable.COL_ID));
        long date = getLong(getColumnIndex(DayTable.COL_DATE));
        String title = getString(getColumnIndex(DayTable.COL_TITLE));
        String content = getString(getColumnIndex(DayTable.COL_CONTENT));

        return new Day(id, date, title, content);
    }
}
