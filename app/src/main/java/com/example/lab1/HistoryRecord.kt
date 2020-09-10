package com.example.lab1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HistoryRecord(val result: String, val type: String, val date: String): Parcelable

