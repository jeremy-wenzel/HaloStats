package net.jeremywenzel.halostats.webapi.parsers

import net.jeremywenzel.halostats.core.haloapi.Enemy

class EnemyResponseParser : BaseResponseParser<Array<Enemy>>() {
    override fun getDeserailizedClassType(): Class<Array<Enemy>> {
        return Array<Enemy>::class.java
    }
}
