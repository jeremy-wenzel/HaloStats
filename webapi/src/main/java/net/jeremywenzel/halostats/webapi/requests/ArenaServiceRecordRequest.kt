package net.jeremywenzel.halostats.webapi.requests

import net.jeremywenzel.halostats.core.Constants
import net.jeremywenzel.halostats.core.haloapi.GamerTag
import net.jeremywenzel.halostats.webapi.parsers.ArenaServiceRecordResponseParser
import okhttp3.HttpUrl
import java.net.URLEncoder

class ArenaServiceRecordRequest(val gamerTags: ArrayList<GamerTag>, val seasonId: String = "") : BaseHaloRequest<ArenaServiceRecordResponseParser>() {
    override fun getDownloadUrl(): String {
        val builder: HttpUrl.Builder = buildBase().addPathSegment(Constants.STATS)
                .addPathSegment(Constants.H5)
                .addPathSegment(Constants.SERVICERECORDS)
                .addPathSegment(Constants.ARENA)
                .addQueryParameter(Constants.PLAYERS, buildCommaSeparatedQueryParameter(gamerTags))

        if (seasonId.isNotBlank()) {
            // This query parameter can be blank
            builder.addQueryParameter(Constants.SEASONS, seasonId)
        }

        return builder.toString()
    }

    private fun buildCommaSeparatedQueryParameter(gamerTags: ArrayList<GamerTag>): String =
            URLEncoder.encode(gamerTags.joinToString { it.gamerTag }, "UTF-8")


    override fun getResponseParser(): ArenaServiceRecordResponseParser = ArenaServiceRecordResponseParser()
}