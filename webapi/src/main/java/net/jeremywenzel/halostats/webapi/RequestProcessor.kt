package net.jeremywenzel.halostats.webapi

import kotlinx.coroutines.*
import net.jeremywenzel.halostats.core.util.Logger
import net.jeremywenzel.halostats.webapi.parsers.BaseResponseParser
import net.jeremywenzel.halostats.webapi.requests.BaseHaloRequest
import okhttp3.OkHttpClient
import okhttp3.Response
import java.lang.Exception

object RequestProcessor {

    private val mClient = OkHttpClient()
    private val TOO_MANY_REQUESTS = 429

    suspend fun <T : BaseResponseParser<*>, E> makeRequest(request: BaseHaloRequest<T>): ResponseObject<E> {

        return withContext(Dispatchers.IO) {
            var value : E? = null
            var wasException= false
            try {
                do {
                    val response: Response = mClient.newCall(request.getOkHttpRequest()).execute()
                    Logger.d(response.toString())
                    if (response.code() == TOO_MANY_REQUESTS) {
                        Thread.sleep(10500)
                        continue
                    }
                    val parser = request.getResponseParser()
                    val responseBody = response.body()
                    if (responseBody != null) {
                        value = parser.parseResponse(responseBody.byteStream()) as E?
                    }
                    break
                } while (true)
            } catch (e: Exception) {
                Logger.d("exception", e)
                wasException = true
            }

            ResponseObject(value, wasException)
        }
    }
}