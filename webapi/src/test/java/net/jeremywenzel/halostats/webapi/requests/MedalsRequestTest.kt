package net.jeremywenzel.halostats.webapi.requests

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class MedalsRequestTest {
    lateinit var request : MedalsRequest

    @Before
    fun `Setup Medals Request`() {
        request = MedalsRequest()
        assertNotNull(request)
    }

    @Test
    fun `Verify Request Url`() {
        val url = request.getOkHttpRequest().url().toString()
        assertEquals("https://www.haloapi.com/metadata/h5/metadata/medals", url)
    }
}

