package net.jeremywenzel.halostats.webapi.requests

import net.jeremywenzel.halostats.core.haloapi.GamerTag
import net.jeremywenzel.halostats.webapi.requests.ArenaServiceRecordRequest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ArenaServiceRecordRequestTest {

    lateinit var request: ArenaServiceRecordRequest

    @Before
    fun `Set Arena Service Record Request`() {
        val gamerTags = ArrayList<GamerTag>()
        gamerTags.add(GamerTag("English Crusade"))
        request = ArenaServiceRecordRequest(gamerTags)
    }

    @Test
    fun `Arena Service Record Request DownloadUrl Test`() {
        val okHttpRequest = request.getOkHttpRequest()
        assertEquals("https://www.haloapi.com/stats/h5/servicerecords/arena?players=English%2BCrusade", okHttpRequest.url().toString())
    }
}