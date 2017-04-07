package com.skiwithuge.dirtydiary.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.skiwithuge.dirtydiary.database.DiaryDbSchema.DayTable;

/**
 * Created by skiwithuge on 4/6/17.
 */

public class DiaryBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "diaryBase.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DayTable.TABLENAME + " (" +
                    DayTable.Cols.ID + " TEXT PRIMARY KEY, " +
                    DayTable.Cols.DATE + " TEXT, " +
                    DayTable.Cols.TITLE + " TEXT, " +
                    DayTable.Cols.CONTENT + " TEXT " +
                    ")";

    public DiaryBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
