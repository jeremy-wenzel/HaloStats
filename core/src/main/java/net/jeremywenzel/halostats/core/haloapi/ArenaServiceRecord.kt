package net.jeremywenzel.halostats.core.haloapi

import com.google.gson.annotations.SerializedName

class ArenaServiceRecord(@SerializedName("TotalKills")val kills: Int,
                         @SerializedName("TotalDeaths")val deaths: Int,
                         @SerializedName("TotalAssists")val assists: Int,
                         @SerializedName("TotalGamesWon")val wins: Int,
                         @SerializedName("TotalGamesLost")val loses: Int) {
    // Things we will need
    // Total Kills
    // Total Deaths
    // Total Assists
    // Total Wins
    // Total Loses
    // Kill death ratio?

    override fun toString(): String {
        return "$kills $deaths $assists $wins $loses"
    }
}