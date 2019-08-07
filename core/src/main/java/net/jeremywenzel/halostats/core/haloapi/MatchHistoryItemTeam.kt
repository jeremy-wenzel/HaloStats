package net.jeremywenzel.halostats.core.haloapi

import com.google.gson.annotations.SerializedName

class MatchHistoryItemTeam(@SerializedName("Id") val id: Int,
                           @SerializedName("Score") val score: Int,
                           @SerializedName("Rank") val rank: Int) {
    companion object {
        fun getTeamFromPlayerInfo(teams: Array<MatchHistoryItemTeam>, playerInfo: MatchHistoryItemPlayerInfo): MatchHistoryItemTeam? {
            for (i in 0 until teams.size) {
                if (teams[i].id == playerInfo.teamId) {
                    return teams[i]
                }
            }

            return null
        }
    }
}