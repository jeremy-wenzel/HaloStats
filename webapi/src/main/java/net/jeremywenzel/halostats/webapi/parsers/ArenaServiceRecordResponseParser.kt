package net.jeremywenzel.halostats.webapi.parsers

import com.github.cliftonlabs.json_simple.JsonArray
import com.github.cliftonlabs.json_simple.JsonObject
import net.jeremywenzel.halostats.core.haloapi.ArenaServiceRecord
import java.io.InputStream

class ArenaServiceRecordResponseParser: BaseResponseParser<ArrayList<ArenaServiceRecord>>() {
    override fun parseResponse(byteStream: InputStream): ArrayList<ArenaServiceRecord> {
        val serviceRecords = ArrayList<ArenaServiceRecord>()
        val resultArray = getJsonObjectFromInputStream(byteStream)["Results"] as JsonArray
        for(i in 0 until resultArray.size) {
            val coreObject = resultArray[i] as JsonObject
            val statsObject = (coreObject["Result"] as JsonObject)["ArenaStats"] as JsonObject
            serviceRecords.add(getServiceRecordFromJsonObject(statsObject))
        }
        return serviceRecords
    }

    private fun getServiceRecordFromJsonObject(statsObject: JsonObject): ArenaServiceRecord {
        val kills = statsObject.getInteger(getJsonKeyWithIntValue("TotalKills"))
        val deaths = statsObject.getInteger(getJsonKeyWithIntValue("TotalDeaths"))
        val assists = statsObject.getInteger(getJsonKeyWithIntValue("TotalAssists"))
        val wins = statsObject.getInteger(getJsonKeyWithIntValue("TotalGamesWon"))
        val loses = statsObject.getInteger(getJsonKeyWithIntValue("TotalGamesLost"))
        return ArenaServiceRecord(kills, deaths, assists, wins, loses)
    }
}