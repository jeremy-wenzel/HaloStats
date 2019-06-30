package net.jeremywenzel.halostats.webapi.parsers

import com.github.cliftonlabs.json_simple.JsonArray
import com.github.cliftonlabs.json_simple.JsonKey
import com.github.cliftonlabs.json_simple.JsonObject
import com.github.cliftonlabs.json_simple.Jsoner
import com.google.gson.Gson
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
     open fun parseResponse(byteStream: InputStream): T {
        return getObjectFromByteStream(byteStream, getClassType())
    }

    abstract fun getClassType(): Class<T>

    /**
     * Gets a [JsonArray] from the [InputStream]. This is typically used when we know the
     * response of a request will be a [JsonArray]
     *
     * @param inputStream The [InputStream] of [okhttp3.ResponseBody] to a request
     * @return A [JsonArray] of the stream
     */
    protected fun getJsonArrayFromInputStream(inputStream: InputStream): JsonArray {
        val jsonString = getStringFromByteStream(inputStream)
        return Jsoner.deserialize(jsonString, JsonArray())
    }

    /**
     * Gets a [JsonObject] from the [InputStream]. This is typically used when we know the
     * response of a request will be a [JsonObject]
     *
     * @param inputStream The [InputStream] of [okhttp3.ResponseBody] to a request
     * @return A [JsonObject] of the stream
     */
    protected fun getJsonObjectFromInputStream(inputStream: InputStream): JsonObject {
        val jsonString = getStringFromByteStream(inputStream)
        return Jsoner.deserialize(jsonString, JsonObject())
    }

    /**
     * Gets the string object from the [InputStream]
     *
     * @param byteStream The [InputStream] that is going to be parsed
     * @return A [String] representation of the byte stream
     */
    fun getStringFromByteStream(byteStream: InputStream): String {
        val stringBuilder = StringBuilder()
        try {
            var value = byteStream.read()
            while (value != -1) {
                stringBuilder.append(value.toChar())
                value = byteStream.read()
            }
        } catch (e: IOException) {
            Logger.d("IOException while reading from byte stream")
            throw e
        }

        return stringBuilder.toString()
    }

    /**
     * Gets the [JsonKey] interface object with [String] defaultValue. The string defaultValue is empty by default
     *
     * @param key The string key
     * @param defaultValue The string default
     * @return A JsonKey interface object
     */
    protected fun getJsonKeyWithStringValue(key: String, defaultValue: String = ""): JsonKey {
        return getJsonKeyFromKeyAndValue(key, defaultValue)
    }

    /**
     * Gets the [JsonKey] interface object with [Int] defaultValue. The string defaultValue is empty by default
     *
     * @param key The string key
     * @param defaultValue The integer default
     * @return A JsonKey interface object
     */
    protected fun getJsonKeyWithIntValue(key: String, defaultValue: Int = -1): JsonKey {
        return getJsonKeyFromKeyAndValue(key, defaultValue)
    }

    /**
     * Gets the [JsonKey] interface object with [Any] value.
     *
     * @param key The [String] key value
     * @param value The [Any] value
     * @return A JsonKey interface object
     */
    private fun getJsonKeyFromKeyAndValue(key: String, value: Any): JsonKey {
        return object : JsonKey {
            override fun getValue(): Any {
                return value
            }

            override fun getKey(): String {
                return key
            }

        }
    }

    protected fun <E> getObjectFromByteStream(byteStream: InputStream, klass: Class<E>) : E {
        val jsonString = getStringFromByteStream(byteStream)
        return Gson().fromJson(jsonString, klass)
    }
}