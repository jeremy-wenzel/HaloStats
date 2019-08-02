package net.jwenzel.dashboard.medals_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import net.jeremywenzel.halostats.core.haloapi.ArenaServiceRecord
import net.jeremywenzel.halostats.core.haloapi.Medal
import net.jwenzel.dashboard.R
import net.jwenzel.dashboard.dashboard.DashboardCardFragment

class MedalsCardFragment: DashboardCardFragment<MedalsCardView, MedalsCardPresenter>(), MedalsCardView {
    private lateinit var medalsLayout: LinearLayout

    override fun getCardLayoutId(): Int = R.layout.medals_card_fragment

    override fun getCardTitleId(): Int = R.string.medals_card_title

    override fun createPresenter(): MedalsCardPresenter = MedalsCardPresenterImpl(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)!!
        medalsLayout = view.findViewById(R.id.medals_layout) as LinearLayout
        return view
    }

    override fun showMedals(medalsMetadata: Array<Medal>, playerMedals: Array<ArenaServiceRecord.MedalAward>) {
        val medalsToShow = ArrayList<Medal>()
        for (i in 0 until 5) {
            if (i >= playerMedals.size) {
                break
            }

            val medal = Medal.getMedalFromArrayWithId(medalsMetadata, playerMedals[i].medalId)
            if (medal != null)
                medalsToShow.add(medal)
        }

        for (i in 0 until medalsToShow.size) {
            val layout = layoutInflater.inflate(R.layout.medal_card_item, null)
            val textView = layout.findViewById(R.id.medal_card_item_text_view) as TextView
            textView.text = medalsToShow[i].name
            medalsLayout.addView(layout)
        }


    }
}