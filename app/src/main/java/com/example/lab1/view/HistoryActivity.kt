package com.example.lab1.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab1.viewModel.HistoryListAdapter
import com.example.lab1.R
import com.example.lab1.model.room.AppDatabase
import com.example.lab1.model.room.HistoryRecord

class HistoryActivity : AppCompatActivity() {

    //private var mHistories: java.util.ArrayList<HistoryRecord>? = java.util.ArrayList()

    private lateinit var mHistories: Array<HistoryRecord>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        mHistories = AppDatabase.getInstanceAppDataBase(this)?.historyDAO()!!.getAllHistory()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView_history)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = HistoryListAdapter(mHistories)
    }
}