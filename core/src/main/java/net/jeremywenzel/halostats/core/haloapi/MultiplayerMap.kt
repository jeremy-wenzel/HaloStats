package net.jeremywenzel.halostats.core.haloapi

import com.google.gson.annotations.SerializedName

data class MultiplayerMap(@SerializedName("name")val name: String?,
                          @SerializedName("description")val description: String?,
                          @SerializedName("imageUrl")       val imageUrl: String)