package net.jeremywenzel.halostats.webapi.requests

import net.jeremywenzel.halostats.core.Constants
import net.jeremywenzel.halostats.core.haloapi.GamerTag
import net.jeremywenzel.halostats.webapi.parsers.PlayerAppearanceResponseParser
import java.net.URLEncoder

class PlayerAppearanceRequest(private val gamerTag: GamerTag) : BaseHaloRequest<PlayerAppearanceResponseParser>() {
    override fun getResponseParser(): PlayerAppearanceResponseParser = PlayerAppearanceResponseParser()

    override fun getDownloadUrl(): String {
        val builder = buildHaloBaseUrl()
                .addPathSegment(Constants.PROFILE)
                .addPathSegment(Constants.H5)
                .addPathSegment(Constants.PROFILES)
                .addPathSegment(URLEncoder.encode(gamerTag.gamerTag, "UTF-8"))
                .addPathSegment(Constants.APPEARANCE)
        return builder.toString()
    }

}