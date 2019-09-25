package com.example.lesson13.controllers

import android.content.ContentValues
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import com.example.lesson13.R
import com.example.lesson13.databases.StudentsDB

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //TODO: Activity can't hold Data base code. -> DAO
        //-> Class / Model / entity Student


        //init our helper
        val sb = StudentsDB(this)
        //get a ref to our writable database
        val db = sb.writableDatabase

        //prefer insert OVER rawQuery -handle cases of SQL Injections
        val cv = ContentValues()
        cv.put("name", "Idan")
        cv.put("email", "idansair@gmail.com")

        val insert = db.insert(StudentsDB.TABLE_NAME, null, cv)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
