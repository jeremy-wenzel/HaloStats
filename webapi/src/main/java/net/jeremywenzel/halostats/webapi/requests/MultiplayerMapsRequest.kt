package net.jeremywenzel.halostats.webapi.requests

import net.jeremywenzel.halostats.core.Constants
import net.jeremywenzel.halostats.webapi.parsers.ArenaServiceRecordResponseParser
import net.jeremywenzel.halostats.webapi.parsers.MultiplayerMapsResponseParser

class MultiplayerMapsRequest: BaseHaloMetadataRequest<MultiplayerMapsResponseParser>() {
    override fun getDownloadUrl(): String {
        return buildHaloBaseUrl()
                .addPathSegment(Constants.MAPS)
                .toString()
    }

    override fun getResponseParser(): MultiplayerMapsResponseParser = MultiplayerMapsResponseParser()
}