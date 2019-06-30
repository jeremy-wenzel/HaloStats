package net.jeremywenzel.halostats.core.haloapi

import com.google.gson.annotations.SerializedName

data class SpriteLocation(@SerializedName("spriteSheetUri")val spriteSheetUri: String,
                          @SerializedName("left")val left: Int,
                          @SerializedName("top")val top: Int,
                          @SerializedName("width")val sheetWidth: Int,
                          @SerializedName("height")val sheetHeight: Int,
                          @SerializedName("spriteWidth")val spriteWidth: Int,
                          @SerializedName("spriteHeight")val spriteHeight: Int)