package com.example.lab1.viewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.lab1.databinding.RowHistoryBinding
import com.example.lab1.model.room.HistoryRecord


//java.util.ArrayList<HistoryRecord>?
class HistoryListAdapter(private val histories: Array<HistoryRecord>)
    : RecyclerView.Adapter<HistoryListAdapter.HistoryItemViewHolder>() {

    override fun getItemCount(): Int = histories?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: RowHistoryBinding = RowHistoryBinding.inflate(inflater, parent, false)
        return HistoryItemViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: HistoryItemViewHolder, position: Int) {
        val historyRecord = histories?.get(position)
        holder.binding?.historyRecord = historyRecord
    }

    class HistoryItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: RowHistoryBinding? = DataBindingUtil.bind(itemView)
    }
}