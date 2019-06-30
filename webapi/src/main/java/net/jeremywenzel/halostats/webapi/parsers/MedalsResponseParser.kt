package net.jeremywenzel.halostats.webapi.parsers

import net.jeremywenzel.halostats.core.haloapi.Medal

class MedalsResponseParser : BaseResponseParser<Array<Medal>>() {
    override fun getDeserailizedClassType(): Class<Array<Medal>> {
        return Array<Medal>::class.java
    }
}