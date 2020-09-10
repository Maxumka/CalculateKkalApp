package com.example.lab1

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.text.StringBuilder

class HistoryListAdapter(private val histories: java.util.ArrayList<HistoryRecord>?)
    : RecyclerView.Adapter<HistoryListAdapter.HistoryItemViewHolder>() {

    // "?." - "safe calls", этот оператор производит проверку на null, вернет histories.size, если histories не null, иначе вернет null
    // "?:" - "elvis operator", этот оператор снова производить проверку на null, если histories?.size вернуло null, то вернется 0,
    // иначе бы вернулась histories?.size
    override fun getItemCount(): Int = histories?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryItemViewHolder {
        Log.d("Adapter", "onCreateViewHolder")
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_history, parent, false)
        return HistoryItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HistoryItemViewHolder, position: Int) {
        Log.d("Adapter", "onBindViewHolder for pos $position")
        holder.textViewResult.text = StringBuilder().append(holder.textViewResult.text).append(histories?.get(position)?.result)
        holder.textViewType.text = StringBuilder().append(holder.textViewType.text).append(histories?.get(position)?.type)
        holder.textViewDate.text = StringBuilder().append(holder.textViewDate.text ).append(histories?.get(position)?.date)
    }

    class HistoryItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewResult: TextView = itemView.findViewById(R.id.textViewResult)
        var textViewType: TextView = itemView.findViewById(R.id.textViewType)
        var textViewDate: TextView = itemView.findViewById(R.id.textViewDate)
    }
}