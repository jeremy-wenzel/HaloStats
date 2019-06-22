package net.jeremywenzel.halostats.webapi

import net.jeremywenzel.halostats.Enemy
import java.io.InputStream

class EnemyResponseParser: BaseResponseParser<ArrayList<Enemy>>() {
    override fun parseResponse(byteStream: InputStream): ArrayList<Enemy> {
        return ArrayList()
    }
}