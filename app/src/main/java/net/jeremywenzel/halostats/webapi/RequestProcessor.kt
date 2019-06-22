package net.jeremywenzel.halostats.webapi

import android.support.annotation.WorkerThread
import net.jeremywenzel.halostats.Logger
import net.jeremywenzel.halostats.webapi.requests.BaseHaloRequest
import okhttp3.OkHttpClient
import okhttp3.Response
import java.lang.Exception

object RequestProcessor {

    var mClient = OkHttpClient()

    @WorkerThread
    fun <T : BaseResponseParser<*>>makeRequest(request: BaseHaloRequest<T>) {
        try {
            val response: Response = mClient.newCall(request.getOkHttpRequest()).execute()
            Logger.d(response.toString())
        } catch (e: Exception) {
            Logger.d("exception", e)
        }
    }
}