package net.jeremywenzel.halostats.webapi

import kotlinx.coroutines.*
import net.jeremywenzel.halostats.core.util.Logger
import net.jeremywenzel.halostats.webapi.parsers.BaseResponseParser
import net.jeremywenzel.halostats.webapi.requests.BaseHaloRequest
import okhttp3.OkHttpClient
import okhttp3.Response
import java.lang.Exception

object RequestProcessor {

    var mClient = OkHttpClient()

    suspend fun <T : BaseResponseParser<*>, E> makeRequest(request: BaseHaloRequest<T>): ResponseObject<E> {

        return withContext(Dispatchers.IO) {
            var value : E? = null
            var wasException= false
            try {
                val response: Response = mClient.newCall(request.getOkHttpRequest()).execute()
                Logger.d(response.toString())
                val parser = request.getResponseParser()
                val responseBody = response.body()
                if (responseBody != null) {
                    value = parser.parseResponse(responseBody.byteStream()) as E?
                }
            } catch (e: Exception) {
                Logger.d("exception", e)
                wasException = true
            }

            ResponseObject(value, wasException)
        }
    }
}