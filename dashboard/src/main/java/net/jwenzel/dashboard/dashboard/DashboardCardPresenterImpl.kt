package net.jwenzel.dashboard.dashboard

import net.jwenzel.coremvp.fragment.BasePresenterImpl

abstract class DashboardCardPresenterImpl<T: DashboardCardView>(view: T): BasePresenterImpl<T>(view), DashboardCardPresenter<T> {
}