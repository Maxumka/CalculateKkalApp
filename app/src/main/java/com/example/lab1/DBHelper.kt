package com.example.lab1

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, TABLE_NAME, null, VERSION) {

    companion object {
        const val TABLE_NAME = "history"

        const val _ID = "_id"
        const val RESULT = "result"
        const val TYPE = "type"
        const val DATE = "date"

        const val VERSION = 1

        private const val CREATE_TABLE: String = "CREATE TABLE $TABLE_NAME (" +
                "$_ID INTEGER PRIMARY KEY," +
                "$RESULT TEXT," +
                "$TYPE TEXT," +
                "$DATE TEXT)"

        private const val DROP_TABLE: String = "DROP TABLE IF EXISTS $TABLE_NAME"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL(DROP_TABLE)
        onCreate(p0)
    }
}