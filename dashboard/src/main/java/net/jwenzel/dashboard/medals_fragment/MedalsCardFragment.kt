package net.jwenzel.dashboard.medals_fragment

import net.jwenzel.dashboard.R
import net.jwenzel.dashboard.dashboard.DashboardCardFragment

class MedalsCardFragment: DashboardCardFragment<MedalsCardView, MedalsCardPresenter>(), MedalsCardView {
    override fun getCardLayoutId(): Int = R.layout.medals_card_fragment

    override fun getCardTitleId(): Int = R.string.medals_card_title

    override fun createPresenter(): MedalsCardPresenter = MedalsCardPresenterImpl(this)
}