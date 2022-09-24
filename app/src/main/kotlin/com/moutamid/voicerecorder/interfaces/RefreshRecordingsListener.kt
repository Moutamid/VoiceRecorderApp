package com.moutamid.voicerecorder.interfaces

import com.moutamid.voicerecorder.models.Recording


interface RefreshRecordingsListener {
    fun refreshRecordings()

    fun playRecording(recording: Recording, playOnPrepared: Boolean)
}
