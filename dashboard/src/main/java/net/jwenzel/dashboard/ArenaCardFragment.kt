package net.jwenzel.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import net.jeremywenzel.halostats.core.haloapi.ArenaServiceRecord
import net.jwenzel.coremvp.fragment.BaseMvpFragment

class ArenaCardFragment: BaseMvpFragment<ArenaCardView, ArenaCardPresenter>(), ArenaCardView {

    private lateinit var killsValueView: TextView

    override fun createPresenter(): ArenaCardPresenter = ArenaCardPresenterImpl(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.arena_card_fragment, container, false)
        killsValueView = view.findViewById(R.id.arena_kills_value)
        return view
    }

    override fun showServiceRecord(areneaServiceRecord: ArenaServiceRecord) {
        killsValueView.text = areneaServiceRecord.kills.toString()
    }
}