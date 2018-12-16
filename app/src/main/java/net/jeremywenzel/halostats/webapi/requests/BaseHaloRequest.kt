package net.jeremywenzel.halostats.webapi.requests

import net.jeremywenzel.halostats.Constants
import okhttp3.HttpUrl
import okhttp3.Request

abstract class BaseHaloRequest {

    protected open fun buildBase(): HttpUrl.Builder {
        return HttpUrl.Builder().scheme(Constants.HTTPS_SCHEME).host(Constants.BASE_HALO_API)
    }

    protected abstract fun getDownloadUrl(): String

    fun getOkHttpRequest(): Request {
        return Request.Builder()
                .url(getDownloadUrl())
                .addHeader("Ocp-Apim-Subscription-Key", Constants.HALO_API_KEY)
                .build()
    }

}