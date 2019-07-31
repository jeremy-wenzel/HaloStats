package net.jeremywenzel.halostats.webapi.requests

import org.junit.Assert.assertEquals
import org.junit.Test

class GameBaseVariantRequestTest {

    @Test
    fun `Verify Url For Request`() {
        val request = GameBaseVariantRequest().getOkHttpRequest().url().toString()
        assertEquals("https://www.haloapi.com/metadata/h5/metadata/game-base-variants", request)
    }
}