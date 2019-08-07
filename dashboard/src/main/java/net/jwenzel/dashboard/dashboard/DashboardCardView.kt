package net.jwenzel.dashboard.dashboard

import net.jwenzel.coremvp.fragment.BaseView

interface DashboardCardView: BaseView {
    fun launchCardFragment()
}