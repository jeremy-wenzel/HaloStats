package net.jeremywenzel.halostats.webapi.requests

import net.jeremywenzel.halostats.core.haloapi.GamerTag
import org.junit.Assert.assertEquals
import org.junit.Test

class PlayerEmblemRequestTest {

    @Test
    fun `Get Request URL with size 256`() {
        val request = PlayerEmblemRequest(GamerTag("English Crusade"), 256)
        assertEquals("https://www.haloapi.com/profile/h5/profiles/English+Crusade/emblem?size=256", request.getRequestUrl())
    }

    @Test
    fun `Get Request URL with size 512`() {
        val request = PlayerEmblemRequest(GamerTag("English Crusade"), 512)
        assertEquals("https://www.haloapi.com/profile/h5/profiles/English+Crusade/emblem?size=512", request.getRequestUrl())
    }

}