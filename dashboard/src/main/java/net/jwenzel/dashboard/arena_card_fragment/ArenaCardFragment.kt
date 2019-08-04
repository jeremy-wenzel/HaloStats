package net.jwenzel.dashboard.arena_card_fragment

import android.os.Bundle
import android.support.annotation.StringRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import net.jeremywenzel.halostats.core.haloapi.ArenaServiceRecord
import net.jwenzel.dashboard.R
import net.jwenzel.dashboard.dashboard.DashboardCardFragment

class ArenaCardFragment: DashboardCardFragment<ArenaCardView, ArenaCardPresenter>(), ArenaCardView {
    private lateinit var arenaFirstFrameRow: LinearLayout
    private lateinit var arenaSecondFrameRow: LinearLayout

    override fun createPresenter(): ArenaCardPresenter = ArenaCardPresenterImpl(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)!!
        arenaFirstFrameRow = view.findViewById(R.id.arena_card_value_first_row)
        arenaSecondFrameRow = view.findViewById(R.id.arena_card_value_second_row)
        return view
    }

    override fun showServiceRecord(arenaServiceRecord: ArenaServiceRecord) {
        arenaFirstFrameRow.removeAllViews()
        addNewFrameValueToRow(arenaServiceRecord.kills, R.string.arena_kills_title, arenaFirstFrameRow)
        addNewFrameValueToRow(arenaServiceRecord.deaths, R.string.arena_deaths_title, arenaFirstFrameRow)
        addNewFrameValueToRow(arenaServiceRecord.assists, R.string.arena_assists_title, arenaFirstFrameRow)

//        arenaSecondFrameRow.removeAllViews()
//        addNewFrameValueToRow(arenaServiceRecord.wins, R.string.arena_wins_title, arenaSecondFrameRow)
//        addNewFrameValueToRow(arenaServiceRecord.losses, R.string.arena_losses_title, arenaSecondFrameRow)
//        addNewFrameValueToRow(arenaServiceRecord.draws, R.string.arena_draws_title, arenaSecondFrameRow)
        addNewFrameValueToRow(arenaServiceRecord.wins, R.string.arena_wins_title, arenaFirstFrameRow)
        addNewFrameValueToRow(arenaServiceRecord.losses, R.string.arena_losses_title, arenaFirstFrameRow)
        addNewFrameValueToRow(arenaServiceRecord.draws, R.string.arena_draws_title, arenaFirstFrameRow)
    }

    private fun addNewFrameValueToRow(value: Any, @StringRes title: Int, frameRow: LinearLayout) {
        val arenaCardValueFrame = layoutInflater.inflate(R.layout.arena_card_value_frame, null)
        arenaCardValueFrame.findViewById<TextView>(R.id.arena_card_value_frame_title).text = resources.getString(title)
        arenaCardValueFrame.findViewById<TextView>(R.id.arena_card_value_frame_value).text = value.toString()

        frameRow.addView(arenaCardValueFrame)
    }

    override fun getCardLayoutId(): Int = R.layout.arena_card_fragment

    override fun getCardTitleId(): Int = R.string.arena_card_title
}