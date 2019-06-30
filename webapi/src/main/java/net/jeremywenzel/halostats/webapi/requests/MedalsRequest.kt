package net.jeremywenzel.halostats.webapi.requests

import net.jeremywenzel.halostats.webapi.parsers.MedalsResponseParser

class MedalsRequest() : BaseHaloMetadataRequest<MedalsResponseParser>() {
    override fun getResponseParser(): MedalsResponseParser {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDownloadUrl(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}