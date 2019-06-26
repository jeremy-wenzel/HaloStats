package net.jeremywenzel.halostats.webapi.parsers

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class EnemyProcessingTest: BaseProcessingTest() {

    @Test
    fun `Enemy Response Parsing Test`() {
        val responseStream = getResponseInputStream("EnemyRequest.json")
        val enemyResponseParser = EnemyResponseParser()
        val enemyList = enemyResponseParser.parseResponse(responseStream)
        assertNotNull(enemyList)
        assertEquals(12, enemyList.size)

        val enemy0 = enemyList[0]
        assertNotNull(enemy0)
        assertEquals("Covenant", enemy0.faction)
        assertEquals("Grunt", enemy0.name)
        assertEquals("https://content.halocdn.com/media/Default/games/halo-5-guardians/api/enemies/grunt-542x305-e637c16cb8aa464c86f305c011803de3.png", enemy0.largeIcon)
        assertEquals("https://content.halocdn.com/media/Default/games/halo-5-guardians/api/enemies/grunt-332x132-f2dfd3a39ba346918e61e0127a5d7190.png", enemy0.smallIcon)

        val enemy11 = enemyList[11]
        assertNotNull(enemy11)
        assertEquals("Unknown", enemy11.faction)
        assertEquals("Wasp", enemy11.name)
        assertEquals("https://content.halocdn.com/media/Default/games/halo-5-guardians/api/enemy-placeholder-542x305-8d4027eda7c04fac94d7a96a49be6d92.png", enemy11.largeIcon)
        assertEquals("https://content.halocdn.com/media/Default/games/halo-5-guardians/api/enemy-placeholder-332x132-7e6442d1e41d4e58aa770adfb27cacbe.png", enemy11.smallIcon)
    }
}
