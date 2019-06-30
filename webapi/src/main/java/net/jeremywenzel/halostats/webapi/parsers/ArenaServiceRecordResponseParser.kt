package net.jeremywenzel.halostats.webapi.parsers

import com.google.gson.Gson
import com.google.gson.JsonObject
import net.jeremywenzel.halostats.core.haloapi.ArenaServiceRecord
import java.io.InputStream

class ArenaServiceRecordResponseParser: BaseResponseParser<Array<ArenaServiceRecord>>() {
    override fun parseResponse(byteStream: InputStream): Array<ArenaServiceRecord> {
        val jsonString = getStringFromByteStream(byteStream)
        var jsonObject = Gson().fromJson(jsonString, com.google.gson.JsonObject::class.java)
//        jsonObject = jsonObject.getAsJsonArray("Results")
        return getArrayFromJsonArray(jsonObject.getAsJsonArray("Results"))
    }

    override fun getClassType(): Class<Array<ArenaServiceRecord>> {
        throw NotImplementedError()
    }
    fun getArrayFromJsonArray(array: com.google.gson.JsonArray): Array<ArenaServiceRecord> {
        val serviceRecords = ArrayList<ArenaServiceRecord>()
        for(i in 0 until array.size()) {
            val coreObject = array[i] as JsonObject
            val statsObject = (coreObject["Result"] as JsonObject)["ArenaStats"] as JsonObject
            serviceRecords.add(Gson().fromJson(statsObject, ArenaServiceRecord::class.java))
        }
        return serviceRecords.toTypedArray()
    }

//    private fun getServiceRecordFromJsonObject(statsObject: JsonObject): ArenaServiceRecord {
//        val kills = statsObject.getInteger(getJsonKeyWithIntValue("TotalKills"))
//        val deaths = statsObject.getInteger(getJsonKeyWithIntValue("TotalDeaths"))
//        val assists = statsObject.getInteger(getJsonKeyWithIntValue("TotalAssists"))
//        val wins = statsObject.getInteger(getJsonKeyWithIntValue("TotalGamesWon"))
//        val loses = statsObject.getInteger(getJsonKeyWithIntValue("TotalGamesLost"))
//        return ArenaServiceRecord(kills, deaths, assists, wins, loses)
//    }
}