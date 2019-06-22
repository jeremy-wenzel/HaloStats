package net.jeremywenzel.halostats.webapi

import com.github.cliftonlabs.json_simple.JsonArray
import com.github.cliftonlabs.json_simple.JsonObject
import com.github.cliftonlabs.json_simple.Jsoner
import net.jeremywenzel.halostats.core.haloapi.Enemy
import java.io.InputStream

class EnemyResponseParser : BaseResponseParser<ArrayList<Enemy>>() {
    override fun parseResponse(byteStream: InputStream): ArrayList<Enemy> {
        val jsonArray = getEnemyJsonArray(byteStream)
        val returnList = ArrayList<Enemy>()
        for (i in 0 until jsonArray.size) {
            val jsonObject = jsonArray[i] as JsonObject
            returnList.add(getEnemyFromJsonObject(jsonObject))
        }

        return returnList
    }

    private fun getEnemyJsonArray(byteStream: InputStream): JsonArray {
        val jsonString = getStringFromByteStream(byteStream)
        return Jsoner.deserialize(jsonString, JsonArray())
    }

    private fun getEnemyFromJsonObject(jsonObject: JsonObject): Enemy {
        val faction = jsonObject.getString(getJsonKeyWithStringValue("faction"))
        val name = jsonObject.getString(getJsonKeyWithStringValue("name"))
        val largeIcon = jsonObject.getString(getJsonKeyWithStringValue("largeIconImageUrl"))
        val smallIcon = jsonObject.getString(getJsonKeyWithStringValue("smallIconImageUrl"))
        return Enemy(faction, name, largeIcon, smallIcon)
    }
}
