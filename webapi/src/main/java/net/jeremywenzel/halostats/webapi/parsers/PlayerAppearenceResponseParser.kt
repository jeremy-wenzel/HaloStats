package net.jeremywenzel.halostats.webapi.parsers

import com.github.cliftonlabs.json_simple.JsonObject
import net.jeremywenzel.halostats.core.haloapi.GamerTag
import net.jeremywenzel.halostats.core.haloapi.PlayerAppearance
import java.io.InputStream

class PlayerAppearanceResponseParser : BaseResponseParser<PlayerAppearance>() {
    override fun parseResponse(byteStream: InputStream): PlayerAppearance =
            getPlayerAppearanceFromResponseObject(getJsonObjectFromInputStream(byteStream))

    private fun getPlayerAppearanceFromResponseObject(responseObject: JsonObject) : PlayerAppearance {
        val gamerTagString = responseObject.getString(getJsonKeyWithStringValue("Gamertag"))
        val serviceTag = responseObject.getString(getJsonKeyWithStringValue("ServiceTag"))
        val companyJsonObject = responseObject["Company"] as JsonObject
        val companyName = companyJsonObject.getString(getJsonKeyWithStringValue("Name"))
        return PlayerAppearance(GamerTag(gamerTagString), serviceTag, companyName)
    }
}