package net.jeremywenzel.halostats.core.haloapi

import com.google.gson.annotations.SerializedName

class Medal(@SerializedName("name")val name: String,
                 @SerializedName("description")val desc: String,
                 @SerializedName("classification")val classification: String,
                 @SerializedName("difficulty")val difficulty: Int,
                 @SerializedName("spriteLocation")val spriteLocation: SpriteLocation,
                 @SerializedName("id")val id: Long) {
    companion object {
        fun getMedalFromArrayWithId(medals: Array<Medal>, id: Long): Medal? {
            for (i in 0 until medals.size) {
                if (medals[i].id == id) {
                    return medals[i]
                }
            }

            return null
        }
    }
}
