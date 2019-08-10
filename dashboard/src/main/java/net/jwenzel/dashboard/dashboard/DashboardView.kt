package net.jwenzel.dashboard.dashboard

import net.jeremywenzel.halostats.core.haloapi.PlayerAppearance
import net.jwenzel.coremvp.fragment.BaseView

interface DashboardView: BaseView {
    fun showPlayerAppearance(playerAppearance: PlayerAppearance)
}