package com.example.lab1.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [HistoryRecord::class], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun historyDAO(): DAO

    // синглтон для room
    companion object {
        var instance: AppDatabase? = null

        fun getInstanceAppDataBase(context: Context): AppDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(context, AppDatabase::class.java, "history_database")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}