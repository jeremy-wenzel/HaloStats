package net.jeremywenzel.halostats.webapi.parsers

import net.jeremywenzel.halostats.core.haloapi.GameBaseVariant

class GameBaseVariantResponseParser : BaseResponseParser<Array<GameBaseVariant>>() {
    override fun getDeserailizedClassType(): Class<Array<GameBaseVariant>> {
        return Array<GameBaseVariant>::class.java
    }
}