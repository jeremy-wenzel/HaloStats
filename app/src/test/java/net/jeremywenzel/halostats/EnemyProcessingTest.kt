package net.jeremywenzel.halostats

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import net.jeremywenzel.halostats.webapi.EnemyResponseParser
import org.junit.Test
import java.io.InputStream

class EnemyProcessingTest {

    @Test
    fun `Enemy Response Parsing Test`() {
        val responseStream = getResponseInputStream("EnemyRequest.json")
        val enemyResponseParser = EnemyResponseParser()
        val enemyList = enemyResponseParser.parseResponse(responseStream)
        assertNotNull(enemyList)
        assertEquals(0, enemyList.size)
    }

    private fun getResponseInputStream(fileName: String): InputStream {
        return this.javaClass.classLoader?.getResourceAsStream(fileName)!!
    }
}