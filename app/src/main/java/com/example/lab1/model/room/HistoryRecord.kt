package com.example.lab1.model.room

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
class HistoryRecord(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val result: String,
    val type: String,
    val date: String ): Parcelable {

    override fun toString(): String = "Result: $result\nType: $type\nDate: $date\n\n"
}

