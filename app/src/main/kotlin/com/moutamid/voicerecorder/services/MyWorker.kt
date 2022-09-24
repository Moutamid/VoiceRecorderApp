package com.moutamid.voicerecorder.services

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(
    private val context: Context,
    params: WorkerParameters
) : Worker(context, params) {
    private val TAG = "MyWorker"
    override fun doWork(): Result {
        Log.d(TAG, "doWork called for: " + this.id)
        Log.d(TAG, "Service Running: " + RecorderService.isRunning)
        if (!RecorderService.isRunning) {
            Log.d(TAG, "starting service from doWork")
            val intent = Intent(context, RecorderService::class.java)
            ContextCompat.startForegroundService(context, intent)
        }
        return Result.success()
    }

    override fun onStopped() {
        Log.d(TAG, "onStopped called for: " + this.id)
        super.onStopped()
    }
}
