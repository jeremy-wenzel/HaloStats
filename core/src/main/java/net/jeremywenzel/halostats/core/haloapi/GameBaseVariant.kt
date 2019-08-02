package net.jeremywenzel.halostats.core.haloapi

import com.google.gson.annotations.SerializedName

class GameBaseVariant(@SerializedName("name") val name: String,
        @SerializedName("id") val guid: String) {

    companion object {
        fun getGameBaseVariantFromArrayAndId(gameBaseVariants: Array<GameBaseVariant>, guid: String) : GameBaseVariant? {
            for (i in 0 until gameBaseVariants.size) {
                if (gameBaseVariants[i].guid == guid) {
                    return gameBaseVariants[i]
                }
            }

            return null
        }
    }
}