package com.ilham.jpro.mylivedata

import android.os.SystemClock
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainViewModel : ViewModel() {
 
    companion object {
        private const val ONE_SECOND = 1000
    }
 
    private val mInitialTime: Long
    private val mElapsedTime = MutableLiveData<Long?>()
 
    init {
        mInitialTime = SystemClock.elapsedRealtime()
        val timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                val newValue = (SystemClock.elapsedRealtime() - mInitialTime) / 1000
                mElapsedTime.postValue(newValue)
            }
        }, ONE_SECOND.toLong(), ONE_SECOND.toLong())
    }
 
    fun getElapsedTime(): LiveData<Long?> {
        return mElapsedTime
    }
}