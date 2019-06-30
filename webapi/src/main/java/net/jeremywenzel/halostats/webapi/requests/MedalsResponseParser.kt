package net.jeremywenzel.halostats.webapi.requests

import com.google.gson.Gson
import net.jeremywenzel.halostats.core.haloapi.Medal
import net.jeremywenzel.halostats.webapi.parsers.BaseResponseParser
import java.io.InputStream

class MedalsResponseParser : BaseResponseParser<List<Medal>>() {
    override fun parseResponse(byteStream: InputStream): List<Medal> {
        val jsonString = getStringFromByteStream(byteStream)
        return Gson().fromJson(jsonString, Array<Medal>::class.java).toList()
    }
}