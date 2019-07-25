package net.jwenzel.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.jeremywenzel.halostats.core.fragment.BaseMvpFragment

class DashboardFragment: BaseMvpFragment<DashboardView, DashboardPresenter>(), DashboardView {
    override fun createPresenter(): DashboardPresenter = DashboardPresenterImpl()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.dashboard_fragment, container, false)
        requireFragmentManager().beginTransaction().add(R.id.card_layout, ArenaCardFragment()).commit()
        requireFragmentManager().beginTransaction().add(R.id.card_layout, ArenaCardFragment()).commit()
        return view
    }
}