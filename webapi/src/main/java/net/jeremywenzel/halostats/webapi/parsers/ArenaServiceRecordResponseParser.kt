package net.jeremywenzel.halostats.webapi.parsers

import com.google.gson.Gson
import com.google.gson.JsonObject
import net.jeremywenzel.halostats.core.haloapi.ArenaServiceRecord
import java.io.InputStream

class ArenaServiceRecordResponseParser: BaseResponseParser<Array<ArenaServiceRecord>>() {
    override fun parseResponse(byteStream: InputStream): Array<ArenaServiceRecord> {
        val jsonString = getStringFromByteStream(byteStream)
        val responseJsonObject = Gson().fromJson(jsonString, com.google.gson.JsonObject::class.java)
        return getArrayFromJsonArray(responseJsonObject.getAsJsonArray("Results"))
    }

    private fun getArrayFromJsonArray(array: com.google.gson.JsonArray): Array<ArenaServiceRecord> {
        val serviceRecords = ArrayList<ArenaServiceRecord>()
        for(i in 0 until array.size()) {
            val coreObject = array[i] as JsonObject
            val statsObject = (coreObject["Result"] as JsonObject)["ArenaStats"] as JsonObject
            serviceRecords.add(Gson().fromJson(statsObject, ArenaServiceRecord::class.java))
        }
        return serviceRecords.toTypedArray()
    }

    override fun getDeserailizedClassType(): Class<Array<ArenaServiceRecord>> {
        /*
        This is a weird case because the halo api decided to have the actual ArenaServiceRecord object nested
        multiple layers down. We need to parse the response manually so we don't need to be using this method
         */
        throw NotImplementedError()
    }
}