package net.jeremywenzel.halostats.webapi

/**
 * An interface for making requests for glide
 */
interface GlideUrl {
    /**
     * Get the url for the request
     *
     * @return The url string
     */
    fun getRequestUrl(): String
}