package net.jeremywenzel.halostats.webapi.parsers

import net.jeremywenzel.halostats.core.haloapi.MatchHistoryItem
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MatchHistoryProcessingTest: BaseProcessingTest() {

    lateinit var historyItems: Array<MatchHistoryItem>

    @Before
    fun `Setup History Items`() {
        historyItems = MatchHistoryResponseParser().parseResponse(getResponseInputStream("MatchHistoryRequest.json"))
        assertNotNull(historyItems)
    }

    @Test
    fun `Verify History Item Size`() {
        assertEquals(10, historyItems.size)
    }

    @Test
    fun `Verify First Item`() {
        assertEquals("c74c9d0f-f206-11e4-8330-24be05e24f7e", historyItems[0].mapId)
        assertEquals("257a305e-4dd3-41f1-9824-dfe7e8bd59e1", historyItems[0].gameTypeId)
    }
}