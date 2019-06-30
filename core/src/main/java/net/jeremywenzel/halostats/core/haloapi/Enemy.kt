package net.jeremywenzel.halostats.core.haloapi

import com.google.gson.annotations.SerializedName

class Enemy(@SerializedName("faction")val faction: String,
            @SerializedName("name")val name: String,
            @SerializedName("largeIconImageUrl")val largeIcon: String,
            @SerializedName("smallIconImageUrl")val smallIcon: String)