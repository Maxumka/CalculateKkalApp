package com.example.lab1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistoryActivity : AppCompatActivity() {

    private var mHistories: java.util.ArrayList<HistoryRecord>? = java.util.ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val intent = intent

        mHistories = intent.extras?.getParcelableArrayList<HistoryRecord>(MainActivity.HISTORY_KEY)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView_history)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = HistoryListAdapter(mHistories)
    }
}