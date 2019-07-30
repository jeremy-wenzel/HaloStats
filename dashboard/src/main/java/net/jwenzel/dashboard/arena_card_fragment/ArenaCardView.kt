package net.jwenzel.dashboard.arena_card_fragment

import net.jeremywenzel.halostats.core.haloapi.ArenaServiceRecord
import net.jwenzel.dashboard.dashboard.DashboardCardView

interface ArenaCardView: DashboardCardView {
    fun showServiceRecord(arenaServiceRecord: ArenaServiceRecord)
}
