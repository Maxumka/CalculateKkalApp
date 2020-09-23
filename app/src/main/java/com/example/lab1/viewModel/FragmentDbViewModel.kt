package com.example.lab1.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.lab1.model.room.AppDatabase

class FragmentDbViewModel(app: Application): AndroidViewModel(app) {

    private val context = getApplication<Application>().applicationContext

    private var _dbInfo = MutableLiveData<String>()
    val mDbInfo: MutableLiveData<String> = _dbInfo

    fun getDbInfo() {
        val histories = AppDatabase.getInstanceAppDataBase(context)?.historyDAO()!!.getAllHistory()
        mDbInfo.value = histories.joinToString { historyRecord -> historyRecord.toString() }
    }

    fun deleteDbInfo() {
        AppDatabase.getInstanceAppDataBase(context)?.historyDAO()!!.deleteAll()
    }
}