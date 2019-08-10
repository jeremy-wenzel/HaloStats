package net.jwenzel.dashboard.dashboard

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import net.jeremywenzel.halostats.core.haloapi.GamerTag
import net.jeremywenzel.halostats.core.haloapi.PlayerAppearance
import net.jeremywenzel.halostats.webapi.requests.PlayerAppearanceRequest
import net.jwenzel.coremvp.fragment.BasePresenterImpl

class DashboardPresenterImpl(view: DashboardView) : BasePresenterImpl<DashboardView>(view), DashboardPresenter {

    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)

    override fun onStart() {
        super.onStart()
        uiScope.launch {
            sendRequest(PlayerAppearanceRequest(GamerTag("English Crusade")), ::onPlayerAppearanceRequestSuccess)
        }
    }

    private fun onPlayerAppearanceRequestSuccess(playerAppearance: PlayerAppearance) {
        uiScope.launch {
            view?.showPlayerAppearance(playerAppearance)
        }
    }
}