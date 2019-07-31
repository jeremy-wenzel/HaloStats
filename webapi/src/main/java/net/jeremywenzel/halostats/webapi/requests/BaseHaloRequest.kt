package net.jeremywenzel.halostats.webapi.requests

import net.jeremywenzel.halostats.core.Constants
import net.jeremywenzel.halostats.webapi.parsers.BaseResponseParser
import okhttp3.HttpUrl
import okhttp3.Request

/**
 *
 */
abstract class BaseHaloRequest<T: BaseResponseParser<*>> {

    companion object {
        val apiKeyHeader = "Ocp-Apim-Subscription-Key"

        /**
         *
         */
        fun buildHaloBaseUrl(): HttpUrl.Builder {
            return HttpUrl.Builder().scheme(Constants.HTTPS_SCHEME).host(Constants.BASE_HALO_API)
        }
    }

    /**
     *
     */
    fun getOkHttpRequest(): Request {
        return Request.Builder()
                .url(getDownloadUrl())
                .addHeader(apiKeyHeader, Constants.HALO_API_KEY)
                .build()
    }

    /**
     *
     */
    protected abstract fun getDownloadUrl(): String

    /**
     *
     */
    abstract fun getResponseParser(): T
}