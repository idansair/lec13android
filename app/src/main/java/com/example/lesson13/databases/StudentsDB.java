package com.example.lesson13.databases;


//Class to initially create the data base -create the tables

//USED ONCE -> to get the tables.

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

//used all the time -> to grt the db objects
public class StudentsDB extends SQLiteOpenHelper {

    public static final String DB_NAME = "StudentDb";
    public static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "Students";

    public static final String CREATE_TABLE_STUDENTS = "CREATE TABLE " + TABLE_NAME + "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name TEXT NOT NULL," +
            "email TEXT)";

    public StudentsDB(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    //once -> ONLY TABLES CREATED IN THIS STEP
    @Override
    public void onCreate(SQLiteDatabase db) {
        //create your database tables here:
        db.execSQL(CREATE_TABLE_STUDENTS);
    }

    //when we need to update the database structure
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //destroy tables
        db.execSQL("DROP TABLE Students");
        //create new tables
        db.execSQL(CREATE_TABLE_STUDENTS);
    }
}
