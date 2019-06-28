package net.jeremywenzel.halostats.webapi.parsers

import net.jeremywenzel.halostats.core.haloapi.PlayerAppearance
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class PlayerAppearanceResponseProcessingTest: BaseProcessingTest() {

    lateinit var playerAppearance: PlayerAppearance

    @Before
    fun `Get Player Appearance from Response`() {
        playerAppearance = PlayerAppearanceResponseParser().parseResponse(getResponseInputStream("PlayerAppearanceRequest.json"))
    }

    @Test
    fun `Verify player appearance is not null`() {
        assertNotNull(playerAppearance)
    }

    @Test
    fun `Verify service tag`() {
        assertEquals("J113", playerAppearance.serviceTag)
    }

    @Test
    fun `Verify Company Name`() {
        assertEquals("The Queens Weebs", playerAppearance.companyName)
    }
}