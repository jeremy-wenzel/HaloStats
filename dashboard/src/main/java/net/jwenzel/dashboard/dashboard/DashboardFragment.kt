package net.jwenzel.dashboard.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.jwenzel.coremvp.fragment.BaseMvpFragment
import net.jwenzel.dashboard.arena_card_fragment.ArenaCardFragment
import net.jwenzel.dashboard.R
import net.jwenzel.dashboard.match_history_card_fragment.MatchHistoryCardFragment
import net.jwenzel.dashboard.medals_fragment.MedalsCardFragment

class DashboardFragment: BaseMvpFragment<DashboardView, DashboardPresenter>(), DashboardView {
    override fun createPresenter(): DashboardPresenter = DashboardPresenterImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        childFragmentManager.beginTransaction().add(R.id.card_layout, ArenaCardFragment()).commit()
        childFragmentManager.beginTransaction().add(R.id.card_layout, MatchHistoryCardFragment()).commit()
        childFragmentManager.beginTransaction().add(R.id.card_layout, MedalsCardFragment()).commit()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dashboard_fragment, container, false)
    }
}