package net.jeremywenzel.halostats.core.haloapi

import com.google.gson.annotations.SerializedName
import java.time.Duration

class MatchHistoryItem(@SerializedName("GameBaseVariantId") val gameTypeId: String,
                       @SerializedName("MapId") val mapId: String,
                       @SerializedName("MatchDuration") val matchDuration: String,
                       @SerializedName("Teams") val teams: Array<MatchHistoryItemTeam>,
                       @SerializedName("Players") val players: Array<MatchHistoryItemPlayerInfo>) {
    // TODO: Figure how to do scores

    override fun toString(): String {
        return "MatchHistoryItem $gameTypeId $mapId $matchDuration"
    }
}