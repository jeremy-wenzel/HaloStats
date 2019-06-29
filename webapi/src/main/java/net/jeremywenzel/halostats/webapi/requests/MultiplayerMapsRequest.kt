package net.jeremywenzel.halostats.webapi.requests

import net.jeremywenzel.halostats.core.Constants
import net.jeremywenzel.halostats.webapi.parsers.ArenaServiceRecordResponseParser

class MultiplayerMapsRequest: BaseHaloMetadataRequest<ArenaServiceRecordResponseParser>() {
    override fun getDownloadUrl(): String {
        return buildBase()
                .addPathSegment(Constants.MAPS)
                .toString()
    }

    override fun getResponseParser(): ArenaServiceRecordResponseParser {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}