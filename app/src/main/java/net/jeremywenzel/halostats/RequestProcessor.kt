package net.jeremywenzel.halostats

import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.Exception

object RequestProcessor {

    var mClient = OkHttpClient()

    fun makeRequest(request: Request) {
        try {
            val response = mClient.newCall(request).execute()
            Logger.d(response.toString())
        } catch (e: Exception) {
            Logger.d("exception", e)
        }
    }
}