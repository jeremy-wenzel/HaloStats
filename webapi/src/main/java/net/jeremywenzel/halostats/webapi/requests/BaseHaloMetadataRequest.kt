package net.jeremywenzel.halostats.webapi.requests

import net.jeremywenzel.halostats.core.Constants
import net.jeremywenzel.halostats.webapi.parsers.BaseResponseParser
import okhttp3.HttpUrl

abstract class BaseHaloMetadataRequest<T> : BaseHaloRequest<T>() {
    companion object {
        fun buildHaloBaseUrl(): HttpUrl.Builder {
            return BaseHaloRequest.buildHaloBaseUrl()
                    .addPathSegment(Constants.METADATA_STR)
                    .addPathSegment(Constants.H5)
                    .addPathSegment(Constants.METADATA_STR)
        }
    }
}