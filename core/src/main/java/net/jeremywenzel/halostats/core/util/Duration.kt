package net.jeremywenzel.halostats.core.util

import java.lang.IllegalArgumentException

/**
 * A clone of the Duration class in Java 8 but the app would have to upgrade to 26 minimum
 *
 * It is pretty barebones, only support time. But it could be updated to support days, months, and years easily
 */
class Duration {

    var hours: Int = 0
        private set
    var minutes: Int = 0
        private set
    var seconds: Int = 0
        private set

    companion object {
        fun fromIsoString(isoString: String): Duration {
            val duration = Duration()
            var currentInt = 0
            var i = 0
            while (i < isoString.length) {
                val c = isoString[i]

                if (i < 2 && c != 'P' && c != 'T') {
                    throw IllegalArgumentException("String $isoString is not in ISO 8601 format. P and T must be first characters")
                }

                when (c) {
                    'P' -> if (i != 0) throw IllegalArgumentException("String $isoString is not in ISO 8601 format. P not first character")
                    'T' -> if (i != 1) throw IllegalArgumentException("String $isoString is not in ISO 8601 format. T not second character")
                    'H' -> {
                        duration.hours = currentInt
                        currentInt = 0
                    }
                    'M' -> {
                        duration.minutes = currentInt
                        currentInt = 0
                    }
                    'S' -> {
                        duration.seconds = currentInt
                        currentInt = 0
                    }
                    else -> {
                        when {
                            c.isDigit() -> currentInt = (currentInt * 10) + (c - '0')
                            c == '.' -> while (i + 1 < isoString.length && isoString[i + 1].isDigit()) ++i
                            else -> throw IllegalArgumentException("String $isoString is not in ISO 8601 format. Unknown character $c")
                        }
                    }
                }
                i++
            }

            return duration
        }
    }
}