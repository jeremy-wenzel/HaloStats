package net.jeremywenzel.halostats.webapi.parsers

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import net.jeremywenzel.halostats.core.haloapi.MatchHistoryItem
import java.io.InputStream

class MatchHistoryResponseParser: BaseResponseParser<Array<MatchHistoryItem>>() {
    override fun parseResponse(byteStream: InputStream): Array<MatchHistoryItem> {
        val jsonString = getStringFromByteStream(byteStream)
        val responseJsonObject = Gson().fromJson(jsonString, com.google.gson.JsonObject::class.java)
        return getArrayFromJsonArray(responseJsonObject.getAsJsonArray("Results"))
    }

    private fun getArrayFromJsonArray(jsonArray: JsonArray): Array<MatchHistoryItem> {
        val historyList = ArrayList<MatchHistoryItem>()
        jsonArray.forEach { historyList.add(getMatchHistoryItemFromJsonObject(it.asJsonObject)) }
        return historyList.toTypedArray()
    }

    private fun getMatchHistoryItemFromJsonObject(jsonObject: JsonObject): MatchHistoryItem {
        return Gson().fromJson(jsonObject, MatchHistoryItem::class.java)
    }

    override fun getDeserailizedClassType(): Class<Array<MatchHistoryItem>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}