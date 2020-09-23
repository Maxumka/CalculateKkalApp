package com.example.lab1.model.blogic

import android.content.Context
import com.example.lab1.model.room.AppDatabase
import com.example.lab1.model.room.HistoryRecord
import java.text.SimpleDateFormat
import java.util.*

class DatabaseBLogic {

    fun addHistoryRecordToDatabase(context: Context, result: String, type: String) {
        val dateFormat = SimpleDateFormat("dd/M/yyyy hh:mm:ss", Locale("ru"))

        AppDatabase.getInstanceAppDataBase(context)?.historyDAO()
            ?.insert(HistoryRecord(null, result, type, dateFormat.format(Date())))
    }
}