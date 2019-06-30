package net.jeremywenzel.halostats.webapi.parsers

import com.google.gson.Gson
import net.jeremywenzel.halostats.core.haloapi.Medal
import java.io.InputStream

class MedalsResponseParser : BaseResponseParser<Array<Medal>>() {
    override fun getClassType(): Class<Array<Medal>> {
        return Array<Medal>::class.java
    }
//    override fun parseResponse(byteStream: InputStream): List<Medal> {
//        val jsonString = getStringFromByteStream(byteStream)
//        return Gson().fromJson(jsonString, Array<Medal>::class.java).toList()
//    }
}