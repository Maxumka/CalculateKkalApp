package com.example.lab1.view

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.lab1.R
import com.example.lab1.model.blogic.FileBLogic
import com.example.lab1.model.service.ServiceStepCounter
import kotlinx.android.synthetic.main.fragment_step_counter.view.*
import java.io.File
import java.io.IOException

class FragmentStepCounter : Fragment() {

    companion object {
        const val SERVICE_STEP_COUNTER = "serviceStepCounter"
        const val KEY_STEP_COUNT = "keyStepCount"
    }

    private lateinit var mFileBLogic: FileBLogic

    private lateinit var mTextViewStepCount: TextView

    private lateinit var mButtonStart: Button
    private lateinit var mButtonStop: Button

    private var mStepCount: Float = 0f

    // Использую Broadcast так как надо получить данные в фрагмент из службы
    private var mReceiver: BroadcastReceiver = object: BroadcastReceiver() {
        override fun onReceive(p0: Context?, p1: Intent?) {
            mStepCount = p1?.extras?.getFloat(KEY_STEP_COUNT) ?: 0f
            mFileBLogic.writeFile("Step count = $mStepCount\n")
            mTextViewStepCount.text = mStepCount.toInt().toString()
        }
    }

    override fun onResume() {
        super.onResume()
        activity?.registerReceiver(mReceiver, IntentFilter(SERVICE_STEP_COUNTER))
    }

    override fun onDestroy() {
        super.onDestroy()
        activity?.unregisterReceiver(mReceiver)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_step_counter, container, false)

        mFileBLogic = FileBLogic(activity!!.applicationContext)

        mButtonStart = view.button_start_service
        mButtonStop = view.button_stop_service

        mTextViewStepCount = view.textView_step_count

        mButtonStart.setOnClickListener {
            activity?.startService(Intent(activity, ServiceStepCounter::class.java))
        }

        mButtonStop.setOnClickListener {
            activity?.stopService(Intent(activity, ServiceStepCounter::class.java))
        }

        return view
    }
}