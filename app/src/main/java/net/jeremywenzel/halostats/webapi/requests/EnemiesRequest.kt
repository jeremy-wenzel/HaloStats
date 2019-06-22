package net.jeremywenzel.halostats.webapi.requests

import net.jeremywenzel.halostats.Constants
import net.jeremywenzel.halostats.webapi.EnemyResponseParser

class EnemiesRequest: BaseHaloMetadataRequest<EnemyResponseParser>() {

    override fun getDownloadUrl(): String {
        return buildBase().addPathSegment(Constants.ENEMIES).toString()
    }

    override fun getResponseParser(): EnemyResponseParser = EnemyResponseParser()
}