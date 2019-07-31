package net.jwenzel.dashboard.match_history_card_fragment

import net.jeremywenzel.halostats.core.haloapi.MatchHistoryItem
import net.jeremywenzel.halostats.core.haloapi.MultiplayerMap
import net.jwenzel.dashboard.dashboard.DashboardCardView

interface MatchHistoryCardView: DashboardCardView {

    fun showCard(matchHistoryItem: MatchHistoryItem, multiplayerMap: MultiplayerMap)
}