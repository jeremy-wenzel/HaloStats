package net.jeremywenzel.halostats.webapi.parsers

import net.jeremywenzel.halostats.core.haloapi.MultiplayerMap

class MultiplayerMapsResponseParser: BaseResponseParser<Array<MultiplayerMap>>() {
    override fun getDeserailizedClassType(): Class<Array<MultiplayerMap>> {
        return Array<MultiplayerMap>::class.java
    }
}