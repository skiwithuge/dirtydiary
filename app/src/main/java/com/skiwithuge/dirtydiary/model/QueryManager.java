package com.skiwithuge.dirtydiary.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.skiwithuge.dirtydiary.database.DayCursorWrapper;
import com.skiwithuge.dirtydiary.database.DayTable;
import com.skiwithuge.dirtydiary.database.DiaryBaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skiwithuge on 12/3/16.
 */

public class QueryManager {
    private static QueryManager sDayList;

    private SQLiteDatabase mDatabase;

    public static QueryManager get(Context context) {
        if (sDayList == null)
            sDayList = new QueryManager(context);
        return sDayList;
    }

    private QueryManager(Context context) {
        mDatabase = new DiaryBaseHelper(context).getWritableDatabase();
    }

    public void saveDay(long date, String title, String content) {
        ContentValues values = mapToContentValues(date, title, content);
        mDatabase.insert(DayTable.TABLENAME, null, values);
    }

    public void updateDay(Day d) {
        ContentValues values = mapToContentValues(d.getDate(), d.getTitle(), d.getContent());

        mDatabase.update(DayTable.TABLENAME, values,
                DayTable.COL_ID + " = ?",
                new String[]{Long.toString(d.getId())});
    }

    private ContentValues mapToContentValues(long date, String title, String content) {
        ContentValues values = new ContentValues();
        values.put(DayTable.COL_DATE, date);
        values.put(DayTable.COL_TITLE, title);
        values.put(DayTable.COL_CONTENT, content);
        return values;
    }

    public List<Day> getDays() {
        List<Day> days = new ArrayList<>();

        DayCursorWrapper cursor = queryDays(null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            days.add(cursor.mapFromCursor());
            cursor.moveToNext();
        }
        cursor.close();

        return days;
    }

    private DayCursorWrapper queryDays(String whereClause, Object... whereArgs) {
        String[] whereArgsStr = null;
        if (whereArgs.length > 0) {
            whereArgsStr = new String[whereArgs.length];
            for (int i = 0; i < whereArgs.length; i++)
                if (whereArgs[i] != null)
                    whereArgsStr[i] = whereArgs[i].toString();
        }
        Cursor cursor = mDatabase.query(
                DayTable.TABLENAME,
                null, //Columns
                whereClause,
                whereArgsStr,
                null, // groupBy
                null, // having
                "date DESC" // orderBy
        );

        return new DayCursorWrapper(cursor);
    }


    public Day getDay(long id) {
        Day res = null;
        DayCursorWrapper dayCursor = queryDays(DayTable.COL_ID + " = ?", id);

        try {
            if (dayCursor.getCount() > 0) {
                dayCursor.moveToFirst();
                res = dayCursor.mapFromCursor();
            }
        } finally {
            dayCursor.close();
        }

        return res;
    }
}
