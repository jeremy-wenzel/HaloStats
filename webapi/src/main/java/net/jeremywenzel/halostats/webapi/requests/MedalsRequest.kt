package net.jeremywenzel.halostats.webapi.requests

import net.jeremywenzel.halostats.core.Constants
import net.jeremywenzel.halostats.webapi.parsers.MedalsResponseParser

class MedalsRequest : BaseHaloMetadataRequest<MedalsResponseParser>() {
    override fun getResponseParser(): MedalsResponseParser = MedalsResponseParser()

    override fun getDownloadUrl(): String {
        val builder = buildHaloBaseUrl()
        builder.addPathSegment(Constants.MEDALS)
        return builder.toString()
    }
}