package com.example.lab1

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class DBManager(val context: Context) {

    private lateinit var mDBHelper: DBHelper

    private lateinit var mDataBase: SQLiteDatabase

    fun open(): DBManager {
        mDBHelper = DBHelper(context)
        mDataBase = mDBHelper.writableDatabase
        return this
    }

    fun close() {
        mDataBase.close()
    }

    fun insert(historyRecord: HistoryRecord) {
        val contentValue = ContentValues()
        contentValue.put(DBHelper.RESULT, historyRecord.result)
        contentValue.put(DBHelper.TYPE, historyRecord.type)
        contentValue.put(DBHelper.DATE, historyRecord.date)
        mDataBase.insert(DBHelper.TABLE_NAME, null, contentValue)
    }

    fun deleteAll() {
        mDataBase.delete(DBHelper.TABLE_NAME, "", null)
    }

    fun getAllAsText(): String {
        val cursor = fetch()
        var text = ""
        while (cursor.moveToNext()) with(cursor) {
            text += HistoryRecord(getString(getColumnIndex(DBHelper.RESULT)), getString(getColumnIndex(DBHelper.TYPE)),
                getString(getColumnIndex(DBHelper.DATE))).toString()
        }
        cursor.close()
        return text
    }

    private fun fetch(): Cursor = mDataBase.query(
        DBHelper.TABLE_NAME,
        null, // возращает массив столбцов, если null то вернет все
        null, // не фильтровать по столбцам
        null, // не фильтровать по значениям
        null, // не групировать строки
        null, // не групировать по групам строк
        null // не сортировать
    )
}