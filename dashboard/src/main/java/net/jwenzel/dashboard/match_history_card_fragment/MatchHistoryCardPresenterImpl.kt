package net.jwenzel.dashboard.match_history_card_fragment

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import net.jeremywenzel.halostats.core.haloapi.GameBaseVariant
import net.jeremywenzel.halostats.core.haloapi.GamerTag
import net.jeremywenzel.halostats.core.haloapi.MatchHistoryItem
import net.jeremywenzel.halostats.core.haloapi.MultiplayerMap
import net.jeremywenzel.halostats.core.util.Logger
import net.jeremywenzel.halostats.webapi.requests.GameBaseVariantRequest
import net.jeremywenzel.halostats.webapi.requests.MatchHistoryRequest
import net.jeremywenzel.halostats.webapi.requests.MultiplayerMapsRequest
import net.jwenzel.dashboard.dashboard.DashboardCardPresenterImpl

class MatchHistoryCardPresenterImpl(view: MatchHistoryCardView): DashboardCardPresenterImpl<MatchHistoryCardView>(view), MatchHistoryCardPresenter {

    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)
    private lateinit var multiplayerMaps : Array<MultiplayerMap>
    private lateinit var gameBaseVariants: Array<GameBaseVariant>

    override fun onStart() {
        super.onStart()
        uiScope.launch {
            sendRequest(MultiplayerMapsRequest(), ::onMultiplayerMapRequestSuccess)
        }
    }

    private fun onMultiplayerMapRequestSuccess(maps: Array<MultiplayerMap>) {
        uiScope.launch {
            multiplayerMaps = maps
            sendRequest(GameBaseVariantRequest(), ::onGameBaseVariantRequestSuccess)
        }
    }

    private fun onGameBaseVariantRequestSuccess(variants: Array<GameBaseVariant>) {
        Logger.d(variants.first().name)
        uiScope.launch {
            gameBaseVariants = variants
            val gamerTag = GamerTag("English Crusade")
            val gameeModes = ArrayList<String>()
            gameeModes.add("arena")

            sendRequest(MatchHistoryRequest(gamerTag, gameeModes, 0, 1), ::onMatchHistoryRequestSuccess)
        }
    }

    private fun onMatchHistoryRequestSuccess(matches: Array<MatchHistoryItem>) {
        Logger.d(matches[0].toString())
        val map = MultiplayerMap.getMapFromArrayWithGuid(multiplayerMaps, matches[0].mapId)
        val gameBaseVariant = GameBaseVariant.getGameBaseVariantFromArrayAndId(gameBaseVariants, matches[0].gameTypeId)
        if (map != null && gameBaseVariant != null && !isViewNull()) {
            view?.showCard(matches[0], map, gameBaseVariant)
        }
    }
}