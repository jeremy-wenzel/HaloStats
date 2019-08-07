package net.jeremywenzel.halostats.core

import net.jeremywenzel.halostats.core.haloapi.MatchHistoryItemPlayerInfo
import net.jeremywenzel.halostats.core.haloapi.MatchHistoryItemTeam
import org.junit.Assert.assertEquals
import org.junit.Test

class MatchHistoryItemTeamTest {

    @Test
    fun `GetTeamFromPlayerInfo Test`() {
        val playerInfo = MatchHistoryItemPlayerInfo(1)
        val teams = ArrayList<MatchHistoryItemTeam>()
        teams.add(MatchHistoryItemTeam(1, 0, 0))
        teams.add(MatchHistoryItemTeam(0, 0, 0))
        teams.add(MatchHistoryItemTeam(2, 0, 0))

        val team = MatchHistoryItemTeam.getTeamFromPlayerInfo(teams.toTypedArray(), playerInfo)
        assertEquals(1, team?.id)
    }
}