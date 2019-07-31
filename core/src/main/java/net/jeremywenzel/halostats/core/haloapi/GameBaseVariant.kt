package net.jeremywenzel.halostats.core.haloapi

import com.google.gson.annotations.SerializedName

class GameBaseVariant(@SerializedName("name") val name: String,
        @SerializedName("id") val guid: String) {
}