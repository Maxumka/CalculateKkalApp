package com.example.lab1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class HistoryRecord(val result: String, val type: String, val date: String): Parcelable {

    override fun toString(): String = "Result: $result\nType: $type\nDate: $date\n\n"
}

