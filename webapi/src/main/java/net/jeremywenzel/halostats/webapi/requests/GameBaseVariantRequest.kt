package net.jeremywenzel.halostats.webapi.requests

import net.jeremywenzel.halostats.core.Constants
import net.jeremywenzel.halostats.webapi.parsers.GameBaseVariantResponseParser

class GameBaseVariantRequest: BaseHaloMetadataRequest<GameBaseVariantResponseParser>() {
    override fun getDownloadUrl(): String {
        val builder = buildHaloBaseUrl()
        builder.addPathSegment(Constants.GAME_BASE_VARIANTS)
        return builder.toString()
    }

    override fun getResponseParser(): GameBaseVariantResponseParser  = GameBaseVariantResponseParser()
}