package net.jwenzel.dashboard.dashboard

import net.jwenzel.coremvp.fragment.BasePresenter

interface DashboardCardPresenter<V: DashboardCardView> : BasePresenter<V> {
    fun onCardHeaderClicked()
}