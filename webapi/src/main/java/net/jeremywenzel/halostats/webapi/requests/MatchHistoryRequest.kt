package net.jeremywenzel.halostats.webapi.requests

import net.jeremywenzel.halostats.core.Constants
import net.jeremywenzel.halostats.core.haloapi.GamerTag
import net.jeremywenzel.halostats.webapi.parsers.MatchHistoryResponseParser
import java.net.URLEncoder

class MatchHistoryRequest(private val gamerTag: GamerTag,
                          private val gameModes: List<String>,
                          private val start: Int,
                          private val count: Int) : BaseHaloRequest<MatchHistoryResponseParser>() {
    override fun getResponseParser(): MatchHistoryResponseParser = MatchHistoryResponseParser()

    override fun getDownloadUrl(): String {
        val builder = buildHaloBaseUrl()
        builder.addPathSegment(Constants.STATS)
                .addPathSegment(Constants.H5)
                .addPathSegment(Constants.PLAYERS)
                .addPathSegment(URLEncoder.encode(gamerTag.gamerTag, "UTF-8"))
                .addPathSegment(Constants.MATCHES)

        builder.addQueryParameter(Constants.MODES_PARAM, gameModes.joinToString(","))
        builder.addQueryParameter(Constants.START_PARAM, start.toString())
        builder.addQueryParameter(Constants.COUNT_PARAM, count.toString())

        return builder.toString()
    }
}