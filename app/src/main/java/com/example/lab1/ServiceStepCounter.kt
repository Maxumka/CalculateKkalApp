package com.example.lab1

import android.app.Service
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.*

class ServiceStepCounter : Service(), SensorEventListener {

    private var mJob: Job = Job()

    private var mSensor: Sensor? = null

    private var mSensorManger: SensorManager? = null

    private var mStepCount: Float = 0f

    override fun onBind(intent: Intent): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        mSensorManger = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        mSensor = mSensorManger?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

        mSensorManger?.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_UI)

        val endStepCounter = 100000

        // использую корутины для асинхронности
        mJob = GlobalScope.launch {
            for (n in 1..endStepCounter) {
                sendStepCount(mStepCount)
                delay(1L)
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        mSensorManger?.unregisterListener(this)
        mJob.cancel()
        Log.d("Service", "Coroutine END something TODO")
    }

    private fun sendStepCount(stepCount: Float) {
        Log.d("Service", "Step count$stepCount")
        val intent = Intent(FragmentStepCounter.SERVICE_STEP_COUNTER)
        intent.putExtra(FragmentStepCounter.KEY_STEP_COUNT, stepCount)
        sendBroadcast(intent)
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        mStepCount = p0?.values?.get(0) ?: 1f
    }
}
