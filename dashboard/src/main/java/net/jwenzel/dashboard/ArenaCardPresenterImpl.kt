package net.jwenzel.dashboard

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import net.jeremywenzel.halostats.core.fragment.BasePresenterImpl
import net.jeremywenzel.halostats.core.haloapi.ArenaServiceRecord
import net.jeremywenzel.halostats.core.haloapi.GamerTag
import net.jeremywenzel.halostats.webapi.RequestProcessor
import net.jeremywenzel.halostats.webapi.requests.ArenaServiceRecordRequest

class ArenaCardPresenterImpl: BasePresenterImpl<ArenaCardView>(), ArenaCardPresenter {

    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)

    override fun onStart() {
        super.onStart()
        uiScope.launch {
            val list = ArrayList<GamerTag>()
            list.add(GamerTag("English Crusade"))
            val response = RequestProcessor.makeRequest(ArenaServiceRecordRequest(list)) as Array<ArenaServiceRecord>
            Log.d("Tag", response[0].toString())
        }
    }
}