package com.example.intents.time;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class Dbhelper extends SQLiteOpenHelper {

    public Dbhelper(Context context) {
        super(context, "stud.db", null,1 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Event (eventname text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists Event");
        onCreate(db);
    }
}


