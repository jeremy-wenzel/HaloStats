package net.jeremywenzel.halostats.webapi.requests

import net.jeremywenzel.halostats.core.Constants
import okhttp3.HttpUrl
import okhttp3.Request

abstract class BaseHaloRequest<T> {

    private val apiKeyHeader = "Ocp-Apim-Subscription-Key"

    protected open fun buildBase(): HttpUrl.Builder {
        return HttpUrl.Builder().scheme(Constants.HTTPS_SCHEME).host(Constants.BASE_HALO_API)
    }

    protected abstract fun getDownloadUrl(): String

    fun getOkHttpRequest(): Request {
        return Request.Builder()
                .url(getDownloadUrl())
                .addHeader(apiKeyHeader, Constants.HALO_API_KEY)
                .build()
    }

    protected abstract fun getResponseParser(): T
}