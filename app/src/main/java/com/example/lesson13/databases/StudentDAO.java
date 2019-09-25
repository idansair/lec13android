package com.example.lesson13.databases;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.example.lesson13.models.KStudent;
import com.example.lesson13.models.Student;

//Database Access Object
//CRUD  - Create Read Update Delete
public class StudentDAO {

    //properties:
    private SQLiteDatabase db;

    //private ctor
    private StudentDAO(SQLiteDatabase db){
        this.db = db;
    }

    private static StudentDAO instance = null;

    public synchronized static StudentDAO getInstance(Context c){
        //singletone
        if (instance == null){
            StudentsDB sdb = new StudentsDB(c);
            SQLiteDatabase db = sdb.getWritableDatabase();
            instance = new StudentDAO(db);
        }
        return instance;
    }

    public long addStudent(KStudent s){
        ContentValues cv = new ContentValues();
        cv.put("name", s.getName());
        cv.put("name", s.getEmail());

        long id = db.insert("Students",null,cv);
        s.setId((int) id);
        return id;
    }


}
