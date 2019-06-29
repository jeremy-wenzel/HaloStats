package net.jeremywenzel.halostats.webapi.requests

import net.jeremywenzel.halostats.core.Constants
import net.jeremywenzel.halostats.core.haloapi.GamerTag
import net.jeremywenzel.halostats.webapi.GlideUrl
import java.net.URLEncoder

class PlayerEmblemRequest(private val gamerTag: GamerTag, private val imageSize: Int): GlideUrl {

    override fun getRequestUrl(): String {
        val builder = BaseHaloRequest.buildHaloBaseUrl()
        builder.addPathSegment(Constants.PROFILE)
                .addPathSegment(Constants.H5)
                .addPathSegment(Constants.PROFILES)
                .addPathSegment(URLEncoder.encode(gamerTag.gamerTag, "UTF-8"))
                .addPathSegment(Constants.EMBLEM)
                .addQueryParameter("size", imageSize.toString())

        return builder.toString()
    }

    /**
     * Get's the header key for the request
     */
    fun getKeyHeader(): String = BaseHaloRequest.apiKeyHeader

    /**
     * Get's the header value for the request. This is because the halo request requires
     * the api key to be in the request
     */
    fun getHeaderValue(): String = Constants.HALO_API_KEY
}