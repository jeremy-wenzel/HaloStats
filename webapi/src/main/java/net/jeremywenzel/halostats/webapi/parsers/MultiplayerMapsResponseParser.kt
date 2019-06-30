package net.jeremywenzel.halostats.webapi.parsers

import com.github.cliftonlabs.json_simple.JsonArray
import com.github.cliftonlabs.json_simple.JsonObject
import net.jeremywenzel.halostats.core.haloapi.MultiplayerMap
import java.io.InputStream

class MultiplayerMapsResponseParser: BaseResponseParser<Array<MultiplayerMap>>() {
    override fun getClassType(): Class<Array<MultiplayerMap>> {
        return Array<MultiplayerMap>::class.java
    }

//    override fun parseResponse(byteStream: InputStream): Array<MultiplayerMap> {
//        val jsonArray = getJsonArrayFromInputStream(byteStream)
//        return getMultiplayerMapsFromJsonArray(jsonArray)
//    }

    private fun getMultiplayerMapsFromJsonArray(jsonArray: JsonArray): List<MultiplayerMap> {
        val multiplayerMaps: ArrayList<MultiplayerMap> = ArrayList()

        for (i in 0 until jsonArray.size) {
            val multiplayerMap = getMultiplayerMapFromJsonOjbect(jsonArray[i] as JsonObject)
            multiplayerMaps.add(multiplayerMap)
        }

        return multiplayerMaps
    }

    private fun getMultiplayerMapFromJsonOjbect(jsonObject: JsonObject): MultiplayerMap {
        val name = jsonObject.getString(getJsonKeyWithStringValue("name"))
        val description = jsonObject.getString(getJsonKeyWithStringValue("description"))
        val imageUrl = jsonObject.getString(getJsonKeyWithStringValue("imageUrl"))

        return MultiplayerMap(name,description, imageUrl)
    }
}