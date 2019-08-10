package net.jwenzel.dashboard.match_history_card_fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.jwenzel.dashboard.R
import net.jwenzel.dashboard.dashboard.DashboardCardFragment
import net.jwenzel.matchhistory.MatchHistoryItemFragment

class MatchHistoryCardFragment: DashboardCardFragment<MatchHistoryCardView, MatchHistoryCardPresenter>(), MatchHistoryCardView {

    override fun getCardLayoutId(): Int = R.layout.match_history_card_fragment

    override fun getCardTitleId(): Int = R.string.match_history_card_title

    override fun createPresenter(): MatchHistoryCardPresenter = MatchHistoryCardPresenterImpl(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        childFragmentManager.beginTransaction().add(R.id.match_history_card_fragment_container, MatchHistoryItemFragment()).commit()
        return super.onCreateView(inflater, container, savedInstanceState)!!
    }

    override fun getFragmentForCardHeaderClick(): Fragment {
        return MatchHistoryItemFragment()
    }
}