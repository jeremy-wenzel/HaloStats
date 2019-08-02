package net.jwenzel.dashboard.medals_fragment

import net.jeremywenzel.halostats.core.haloapi.ArenaServiceRecord
import net.jeremywenzel.halostats.core.haloapi.Medal
import net.jwenzel.dashboard.dashboard.DashboardCardView

interface MedalsCardView: DashboardCardView {
    fun showMedals(medalsMetadata: Array<Medal>, playerMedals: Array<ArenaServiceRecord.MedalAward>)
}