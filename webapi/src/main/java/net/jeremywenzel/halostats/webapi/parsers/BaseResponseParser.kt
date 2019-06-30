package net.jeremywenzel.halostats.webapi.parsers

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
        return getObjectFromByteStream(byteStream, getDeserailizedClassType())
    }

    /**
     * Gets the class type for deserialization
     *
     * @return The class type that is going to be used for deserialization
     */
    abstract fun getDeserailizedClassType(): Class<T>

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
     * Gets the desired object from the byte stream assuming the byte stream can be deserialized
     * to the desired object
     *
     * @param byteStream The [InputStream] object containing the data to deserialize
     * @param klass The desired class to deserialize to
     * @return An instance of the desired object
     */
    private fun <E> getObjectFromByteStream(byteStream: InputStream, klass: Class<E>): E {
        val jsonString = getStringFromByteStream(byteStream)
        return Gson().fromJson(jsonString, klass)
    }
}