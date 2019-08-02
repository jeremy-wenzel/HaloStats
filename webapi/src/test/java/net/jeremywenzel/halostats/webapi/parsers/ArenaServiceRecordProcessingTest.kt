package net.jeremywenzel.halostats.webapi.parsers

import net.jeremywenzel.halostats.core.haloapi.ArenaServiceRecord
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import java.io.InputStream

class ArenaServiceRecordProcessingTest: BaseProcessingTest() {

    lateinit var serviceRecord: ArenaServiceRecord

    @Before
    fun `Parse Input Stream`() {
        val inputStream: InputStream = getResponseInputStream("ArenaServiceRecordRequest.json")
        serviceRecord = ArenaServiceRecordResponseParser().parseResponse(inputStream)[0] // Should be the first one
    }

    @Test
    fun `Arena Service Record Parsing Test`() {
        assertNotNull(serviceRecord)
    }

    @Test
    fun `Arena Service Record Kills Parsing Test`() {
        assertEquals(8143, serviceRecord.kills)
    }

    @Test
    fun `Arena Service Record Deaths Parsing Test`() {
        assertEquals(7205, serviceRecord.deaths)
    }

    @Test
    fun `Arena Service Record Assists Parsing Test`() {
        assertEquals(2409, serviceRecord.assists)
    }

    @Test
    fun `Arena Service Record Wins Parsing Test`() {
        assertEquals(296, serviceRecord.wins)
    }

    @Test
    fun `Arena Service Record Losses Parsing Test`() {
        assertEquals(322, serviceRecord.losses)
    }

    @Test
    fun `Arena Service Record Ties Parsing Test`() {
        assertEquals(5, serviceRecord.draws)
    }

    @Test
    fun `Arena Medal Award Not Null`() {
        assertNotNull(serviceRecord.medalAwards)
    }

    @Test
    fun `Arena Medal Award First Medal`() {
        assertEquals(3001183151, serviceRecord.medalAwards[0].medalId)
        assertEquals(73, serviceRecord.medalAwards[0].count)
    }
}