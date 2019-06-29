package net.jeremywenzel.halostats.webapi.requests

import org.junit.Assert.assertEquals
import org.junit.Test

class MultiplayerMapRequestTest {

    @Test
    fun `Get Multiplayer Maps Url Test`() {
        val request = MultiplayerMapsRequest()
        assertEquals("https://www.haloapi.com/metadata/h5/metadata/maps", request.getOkHttpRequest().url().toString())
    }
}