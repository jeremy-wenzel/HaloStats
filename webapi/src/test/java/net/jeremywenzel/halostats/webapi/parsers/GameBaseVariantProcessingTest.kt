package net.jeremywenzel.halostats.webapi.parsers

import net.jeremywenzel.halostats.core.haloapi.GameBaseVariant
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GameBaseVariantProcessingTest: BaseProcessingTest() {

    private lateinit var gameBaseVariants: Array<GameBaseVariant>

    @Before
    fun `Setup Game Base Variants`() {
        val inputStream = getResponseInputStream("GameBaseVariantRequest.json")
        gameBaseVariants = GameBaseVariantResponseParser().parseResponse(inputStream)
        assertTrue(gameBaseVariants.isNotEmpty())
    }

    @Test
    fun `Verify First Game Base Variant`() {
        verifyGameVariant(gameBaseVariants.first(), "Strongholds", "1571fdac-e0b4-4ebc-a73a-6e13001b71d3")
    }

    @Test
    fun `Verify Last Game Base Variant`() {
        verifyGameVariant(gameBaseVariants.last(), "Big Team Assault", "657d658d-853a-4e82-9068-7b730720cc7f")
    }

    private fun verifyGameVariant(gameBaseVariant: GameBaseVariant, expectedName: String, expectedGuid: String) {
        assertEquals(expectedName, gameBaseVariant.name)
        assertEquals(expectedGuid, gameBaseVariant.guid)
    }
}