package net.jeremywenzel.halostats.webapi.parsers

import com.github.cliftonlabs.json_simple.JsonKey
import net.jeremywenzel.halostats.core.util.Logger
import java.io.IOException
import java.io.InputStream
import java.lang.StringBuilder

/**
 * The base parser for parsing response objects from http requests
 *
 * <T> refers to the object that will be returned after parsing the response
 */
abstract class BaseResponseParser<T> {

    /**
     * Parses the [InputStream] response body from the [okhttp3.ResponseBody]
     * and returns the object that is in the response
     *
     * @param byteStream The [InputStream] byte stream from the [okhttp3.ResponseBody]
     * @return The desired object that should be in the response
     */
    abstract fun parseResponse(byteStream: InputStream): T

    /**
     * Gets the string object from the [InputStream]
     *
     * @param byteStream The [InputStream] that is going to be parsed
     * @return A [String] representation of the byte stream
     */
    protected fun getStringFromByteStream(byteStream: InputStream): String {
        val stringBuilder = StringBuilder()
        try {
            var value = byteStream.read()
            while (value != -1) {
                stringBuilder.append(value.toChar())
                value = byteStream.read()
            }
        }
        catch (e: IOException) {
            Logger.d("IOException while reading from byte stream")
            throw e
        }

        return stringBuilder.toString()
    }

    /**
     * Gets the [JsonKey] interface object with string defaultValue. The string defaultValue is empty by default
     *
     * @param key The string key
     * @param defaultValue The string default defaultValue
     * @return A JsonKey interface object
     */
    protected fun getJsonKeyWithStringValue(key: String, defaultValue: String = ""): JsonKey {
        return getJsonKeyFromKeyAndValue(key, defaultValue)
    }

    /**
     * Gets the [JsonKey] interface object with [Any] value.
     *
     * @param key The [String] key value
     * @param value The [Any] value
     * @return A JsonKey interface object
     */
    protected fun getJsonKeyFromKeyAndValue(key: String, value: Any): JsonKey {
        return object : JsonKey {
            override fun getValue(): Any {
                return value
            }

            override fun getKey(): String {
                return key
            }

        }
    }
}