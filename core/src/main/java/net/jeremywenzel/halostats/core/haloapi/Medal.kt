package net.jeremywenzel.halostats.core.haloapi

import com.google.gson.annotations.SerializedName

data class Medal(@SerializedName("name")val name: String,
                 @SerializedName("description")val desc: String,
                 @SerializedName("classification")val classification: String,
                 @SerializedName("difficulty")val difficulty: Int,
                 @SerializedName("spriteLocation")val spriteLocation: SpriteLocation)