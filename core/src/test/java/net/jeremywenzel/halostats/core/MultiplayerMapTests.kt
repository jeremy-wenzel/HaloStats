package net.jeremywenzel.halostats.core

import net.jeremywenzel.halostats.core.haloapi.MultiplayerMap
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MultiplayerMapTests {

    lateinit var multiplayerMaps: Array<MultiplayerMap>

    @Before
    fun `Setup multiplayer Maps Array`() {
        val multiplayerMaps = ArrayList<MultiplayerMap>()
        multiplayerMaps.add(MultiplayerMap("test", null, "", "hello"))
        multiplayerMaps.add(MultiplayerMap("test2", null, "", "World"))
        multiplayerMaps.add(MultiplayerMap("test3", null, "", "Freedom!"))

        this.multiplayerMaps = multiplayerMaps.toTypedArray()
    }

    @Test
    fun `getMapFromArrayWithGuid first item test`() {
        val multiplayerMap = MultiplayerMap.getMapFromArrayWithGuid(multiplayerMaps, "hello")
        assertNotNull(multiplayerMap)
        assertEquals("test", multiplayerMap?.name)
    }

    @Test
    fun `getMapFromArrayWithGuid last item test`() {
        val multiplayerMap = MultiplayerMap.getMapFromArrayWithGuid(multiplayerMaps, "Freedom!")
        assertNotNull(multiplayerMap)
        assertEquals("test3", multiplayerMap?.name)
    }

    @Test
    fun `getMapFromArrayWithGuid item doesn't exist test`() {
        val multiplayerMap = MultiplayerMap.getMapFromArrayWithGuid(multiplayerMaps, "Boo")
        assertNull(multiplayerMap)
    }
}