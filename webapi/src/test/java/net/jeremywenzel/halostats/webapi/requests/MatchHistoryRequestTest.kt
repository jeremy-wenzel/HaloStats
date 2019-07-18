package net.jeremywenzel.halostats.webapi.requests

import net.jeremywenzel.halostats.core.haloapi.GamerTag
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MatchHistoryRequestTest {

    lateinit var request: MatchHistoryRequest

    @Before
    fun `Setup Request`() {
        val gamerTag = GamerTag("English Crusade")
        val gameModes = ArrayList<String>()
        gameModes.add("arena")
        gameModes.add("warzone")

        request = MatchHistoryRequest(gamerTag, gameModes, 0, 10)
    }

    @Test
    fun `Verify Request URL`() {
        assertEquals("https://www.haloapi.com/stats/h5/players/English+Crusade/matches?modes=arena%2Cwarzone&start=0&count=10", request.getOkHttpRequest().url().toString())
    }
}