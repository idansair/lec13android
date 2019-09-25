package com.example.lesson13.databases

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class KStudentDB(context:Context): SQLiteOpenHelper(context, "sdb", null, 1) {

    //static in java -> companion object
    companion object{
    val DB_NAME:String = "StudentsDb"
    val DB_VERSION:Int = 1
    val TABLE_NAME:String = "Students"

    //multi line string:
    val CREATE_TABLE_STUDENTS:String = """
        CREATE TABLE $TABLE_NAME(
                                _id INTEGER PRIMARY KEY AUTOINCREMENT,
                                name TEXT NOT NULL,
                                email TEXT);
    """
    }


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE_STUDENTS)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE Students")
        db?.execSQL(CREATE_TABLE_STUDENTS)
    }



}