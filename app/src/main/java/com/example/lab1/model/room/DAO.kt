package com.example.lab1.model.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DAO {
    @Insert
    fun insert(historyRecord: HistoryRecord)

    @Query("SELECT * FROM historyrecord")
    fun getAllHistory(): Array<HistoryRecord>

    @Query("DELETE FROM historyrecord")
    fun deleteAll()
}