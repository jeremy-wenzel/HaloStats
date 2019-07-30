package net.jwenzel.dashboard.match_history_card_fragment

import net.jwenzel.dashboard.R
import net.jwenzel.dashboard.dashboard.DashboardCardFragment

class MatchHistoryCardFragment: DashboardCardFragment<MatchHistoryCardView, MatchHistoryCardPresenter>(), MatchHistoryCardView {
    override fun getCardLayoutId(): Int = R.layout.match_history_card_fragment

    override fun getCardTitleId(): Int = R.string.match_history_card_title

    override fun createPresenter(): MatchHistoryCardPresenter = MatchHistoryCardPresenterImpl(this)
}