package net.jeremywenzel.halostats.webapi.requests

import net.jeremywenzel.halostats.core.haloapi.GamerTag
import org.junit.Assert.assertEquals
import org.junit.Test

class PlayerAppearanceRequestTest {

    @Test
    fun `Player Appearance Request Test`() {
        val request = PlayerAppearanceRequest(GamerTag("English Crusade"))
        val okhttprequest = request.getOkHttpRequest()
        assertEquals("https://www.haloapi.com/profile/h5/profiles/English+Crusade/appearance", okhttprequest.url().toString())
    }
}