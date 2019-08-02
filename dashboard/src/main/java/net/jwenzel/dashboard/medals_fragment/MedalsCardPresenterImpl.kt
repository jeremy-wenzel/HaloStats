package net.jwenzel.dashboard.medals_fragment

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import net.jeremywenzel.halostats.core.haloapi.ArenaServiceRecord
import net.jeremywenzel.halostats.core.haloapi.GamerTag
import net.jeremywenzel.halostats.core.haloapi.Medal
import net.jeremywenzel.halostats.webapi.requests.ArenaServiceRecordRequest
import net.jeremywenzel.halostats.webapi.requests.MedalsRequest
import net.jwenzel.dashboard.dashboard.DashboardCardPresenterImpl

class MedalsCardPresenterImpl(view: MedalsCardView): DashboardCardPresenterImpl<MedalsCardView>(view), MedalsCardPresenter {

    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)

    private lateinit var medalsMetadata: Array<Medal>
    private lateinit var arenaServiceRecord: ArenaServiceRecord

    override fun onStart() {
        super.onStart()
        uiScope.launch {
            sendRequest(MedalsRequest(), ::onMedalsRequestSuccess)
        }
    }

    private fun onMedalsRequestSuccess(medalsMetadata: Array<Medal>) {
        this.medalsMetadata = medalsMetadata
        uiScope.launch {
            val list = ArrayList<GamerTag>()
            list.add(GamerTag("English Crusade"))
            sendRequest(ArenaServiceRecordRequest(list), ::onArenaServiceRecordSuccess)
        }
    }

    private fun onArenaServiceRecordSuccess(arenaServiceRecords: Array<ArenaServiceRecord>) {
        arenaServiceRecord = arenaServiceRecords[0]
        if (view != null) {
            view?.showMedals(medalsMetadata, arenaServiceRecord.medalAwards)
        }
    }
}