package net.jeremywenzel.halostats.webapi.parsers

import net.jeremywenzel.halostats.core.haloapi.PlayerAppearance

class PlayerAppearanceResponseParser : BaseResponseParser<PlayerAppearance>() {
    override fun getDeserailizedClassType(): Class<PlayerAppearance> {
        return PlayerAppearance::class.java
    }
}