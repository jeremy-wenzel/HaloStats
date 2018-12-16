package net.jeremywenzel.halostats.webapi.requests

import net.jeremywenzel.halostats.Constants

class EnemiesRequest: BaseHaloMetadataRequest() {
    override fun getDownloadUrl(): String {
        return buildBase().addPathSegment(Constants.ENEMIES).toString()
    }
}