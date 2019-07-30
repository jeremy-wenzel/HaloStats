package net.jwenzel.dashboard.arena_card_fragment

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import net.jeremywenzel.halostats.core.haloapi.ArenaServiceRecord
import net.jeremywenzel.halostats.core.haloapi.GamerTag
import net.jeremywenzel.halostats.webapi.requests.ArenaServiceRecordRequest
import net.jwenzel.dashboard.dashboard.DashboardCardPresenterImpl

class ArenaCardPresenterImpl(view: ArenaCardView): DashboardCardPresenterImpl<ArenaCardView>(view), ArenaCardPresenter {

    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)

    override fun onStart() {
        super.onStart()
        uiScope.launch {
            val list = ArrayList<GamerTag>()
            list.add(GamerTag("English Crusade"))
            sendRequest(ArenaServiceRecordRequest(list), ::onSucceed)

        }
    }

    private fun onSucceed(result: Array<ArenaServiceRecord>) {
        if (isViewNull()) {
            return
        }

        view!!.showServiceRecord(result[0])
    }
}