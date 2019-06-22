package net.jeremywenzel.halostats.webapi

import java.io.InputStream

abstract class BaseResponseParser<T> {

    abstract fun parseResponse(byteStream: InputStream): T
}