package net.jwenzel.dashboard

import net.jeremywenzel.halostats.core.haloapi.ArenaServiceRecord
import net.jwenzel.coremvp.fragment.BaseView

interface ArenaCardView: BaseView {
    fun showServiceRecord(arenaServiceRecord: ArenaServiceRecord)
}
