package net.jwenzel.dashboard.dashboard

import net.jwenzel.coremvp.fragment.BasePresenterImpl

abstract class DashboardCardPresenterImpl<V: DashboardCardView>(view: V): BasePresenterImpl<V>(view), DashboardCardPresenter<V> {
}