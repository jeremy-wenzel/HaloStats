package net.jeremywenzel.halostats.core.util

import android.util.Log

/**
 * A simple logger so I don't have to constantly add a tag. (Global Tag is good enough)
 *
 * Also if we want to switch to a different logging system we can wrap it in this class
 */
object Logger {

    private const val TAG = "HaloStats"

    fun d(message: String) {
        Log.d(TAG, message)
    }

    fun d(message: String, t: Throwable) {
        Log.d(TAG, message, t)
    }
}
