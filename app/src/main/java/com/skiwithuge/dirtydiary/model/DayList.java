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

public class DayList {
    private static DayList sDayList;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static DayList get(Context context) {
        if (sDayList == null)
            sDayList = new DayList(context);
        return sDayList;
    }

    private DayList(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new DiaryBaseHelper(mContext).getWritableDatabase();
    }

    private static ContentValues getContentValues(Day day) {
        ContentValues values = new ContentValues();
        values.put(DayTable.COL_DATE, day.getDate());
        values.put(DayTable.COL_TITLE, day.getTitle());
        values.put(DayTable.COL_CONTENT, day.getContent());
        return values;
    }

    public void addDay(Day d) {
        ContentValues values = getContentValues(d);
        mDatabase.insert(DayTable.TABLENAME, null, values);
    }

    public void updateDay(Day d) {
        String date = d.getDate();
        ContentValues values = getContentValues(d);

        mDatabase.update(DayTable.TABLENAME, values,
                DayTable.COL_DATE + " = ?",
                new String[]{date});
    }

    private DayCursorWrapper queryDays(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                DayTable.TABLENAME,
                null, //Columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                "date DESC" // orderBy
        );

        return new DayCursorWrapper(cursor);
    }

    public List<Day> getDays() {
        List<Day> days = new ArrayList<>();

        DayCursorWrapper cursor = queryDays(null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            days.add(cursor.getDay());
            cursor.moveToNext();
        }
        cursor.close();

        return days;
    }

    public Day getDay(String date) {
        DayCursorWrapper cursor = queryDays(
                DayTable.COL_DATE + " = ?",
                new String[]{date}
        );

        try {
            if (cursor.getCount() == 0)
                return null;

            cursor.moveToFirst();
            return cursor.getDay();
        } finally {
            cursor.close();
        }
    }
}
