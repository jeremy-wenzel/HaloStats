package net.jeremywenzel.halostats.webapi.requests

import net.jeremywenzel.halostats.core.Constants
import okhttp3.HttpUrl

abstract class BaseHaloMetadataRequest<T>: BaseHaloRequest<T>() {
    override fun buildBase(): HttpUrl.Builder {
        return super.buildBase()
                .addPathSegment(Constants.METADATA_STR)
                .addPathSegment(Constants.H5)
                .addPathSegment(Constants.METADATA_STR)
    }
}