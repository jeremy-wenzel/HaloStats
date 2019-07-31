package net.jeremywenzel.halostats.core.haloapi

import com.google.gson.annotations.SerializedName

class MultiplayerMap(@SerializedName("name")val name: String?,
                          @SerializedName("description")val description: String?,
                          @SerializedName("imageUrl") val imageUrl: String,
                          @SerializedName("id") val mapGuid: String) {

    companion object {
        fun getMapFromArrayWithGuid(maps: Array<MultiplayerMap>, guid: String): MultiplayerMap? {
            for (i in 0 until maps.size) {
                if (maps[i].mapGuid == guid) {
                    return maps[i]
                }
            }

            return null
        }
    }
}