package net.jeremywenzel.halostats.webapi.requests

import net.jeremywenzel.halostats.core.Constants
import net.jeremywenzel.halostats.webapi.parsers.EnemyResponseParser

class EnemiesRequest: BaseHaloMetadataRequest<EnemyResponseParser>() {

    override fun getDownloadUrl(): String {
        return buildBase().addPathSegment(Constants.ENEMIES).toString()
    }

    override fun getResponseParser(): EnemyResponseParser = EnemyResponseParser()
}