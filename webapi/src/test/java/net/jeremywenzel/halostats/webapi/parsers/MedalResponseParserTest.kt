package net.jeremywenzel.halostats.webapi.parsers

import net.jeremywenzel.halostats.core.haloapi.Medal
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class MedalResponseParserTest: BaseProcessingTest() {

    lateinit var medals: Array<Medal>

    @Before
    fun `Get Medals from Response`() {
        val processor = MedalsResponseParser()
        medals = processor.parseResponse(getResponseInputStream("Medals.json"))
    }

    @Test
    fun `Verify Medals is not null`() {
        assertNotNull(medals)
    }

    @Test
    fun `Verify first medal`() {
        assertEquals("Carrier Protected", medals[0].name)
        assertEquals("Save your Oddball carrier by killing his attacker", medals[0].desc)
        assertEquals("Oddball", medals[0].classification)
        assertEquals(0, medals[0].difficulty)
    }

    @Test
    fun `Verify first medal SpriteLocation`() {
        val sprite = medals[0].spriteLocation
        assertNotNull(sprite)
        assertEquals("https://content.halocdn.com/media/Default/games/halo-5-guardians/sprites/medals_10-26-17-1ed917479dd14818b09ef10e29ff60b1.png", sprite.spriteSheetUri)
        assertEquals(518, sprite.left)
        assertEquals(148, sprite.top)
        assertEquals(74, sprite.sheetWidth)
        assertEquals(74, sprite.sheetHeight)
        assertEquals(2048, sprite.spriteWidth)
        assertEquals(1024, sprite.spriteHeight)
    }
}