package net.jeremywenzel.halostats.webapi.parsers

import com.github.cliftonlabs.json_simple.JsonArray
import com.github.cliftonlabs.json_simple.JsonObject
import com.github.cliftonlabs.json_simple.Jsoner
import com.google.gson.Gson
import net.jeremywenzel.halostats.core.haloapi.Enemy
import java.io.InputStream

class EnemyResponseParser : BaseResponseParser<Array<Enemy>>() {
    override fun getClassType(): Class<Array<Enemy>> {
        return Array<Enemy>::class.java
    }

//    override fun parseResponse(byteStream: InputStream): Array<Enemy> {
//        val jsonString = getStringFromByteStream(byteStream)
//        return Gson().fromJson(jsonString, Array<Enemy>::class.java).toList()
////        val jsonArray = getJsonArrayFromInputStream(byteStream)
////        val returnList = ArrayList<Enemy>()
////        for (i in 0 until jsonArray.size) {
////            val jsonObject = jsonArray[i] as JsonObject
////            returnList.add(getEnemyFromJsonObject(jsonObject))
////        }
////
////        return returnList
//    }

    private fun getEnemyFromJsonObject(jsonObject: JsonObject): Enemy {
        val faction = jsonObject.getString(getJsonKeyWithStringValue("faction"))
        val name = jsonObject.getString(getJsonKeyWithStringValue("name"))
        val largeIcon = jsonObject.getString(getJsonKeyWithStringValue("largeIconImageUrl"))
        val smallIcon = jsonObject.getString(getJsonKeyWithStringValue("smallIconImageUrl"))
        return Enemy(faction, name, largeIcon, smallIcon)
    }
}
