package net.jwenzel.matchhistory

import net.jeremywenzel.halostats.core.haloapi.GameBaseVariant
import net.jeremywenzel.halostats.core.haloapi.MatchHistoryItem
import net.jeremywenzel.halostats.core.haloapi.MultiplayerMap
import net.jwenzel.coremvp.fragment.BaseView

interface MatchHistoryItemView: BaseView {

    fun showCard(matchHistoryItem: MatchHistoryItem, multiplayerMap: MultiplayerMap, gameBaseVariant: GameBaseVariant, isVictory: Boolean)
}