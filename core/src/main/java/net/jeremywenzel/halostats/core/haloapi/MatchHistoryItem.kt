package net.jeremywenzel.halostats.core.haloapi

import com.google.gson.annotations.SerializedName
import java.time.Duration

class MatchHistoryItem(@SerializedName("GameBaseVariantId") val gameTypeId: String,
                       @SerializedName("MapId") val mapId: String,
                       @SerializedName("MatchDuration") val matchDuration: String) {
    // TODO: Figure how to do scores

    override fun toString(): String {
        return "MatchHistoryItem $gameTypeId $mapId $matchDuration"
    }
}