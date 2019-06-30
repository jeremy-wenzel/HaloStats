package net.jeremywenzel.halostats.core.haloapi

import com.google.gson.annotations.SerializedName

data class PlayerAppearance(@SerializedName("Gamertag")val gamerTag: String,
                            @SerializedName("ServiceTag")val serviceTag: String,
                            @SerializedName("Company")val company: Company)