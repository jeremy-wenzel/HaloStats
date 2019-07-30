package net.jwenzel.dashboard.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.jwenzel.coremvp.fragment.BaseMvpFragment
import net.jwenzel.dashboard.arena_card_fragment.ArenaCardFragment
import net.jwenzel.dashboard.R

class DashboardFragment: BaseMvpFragment<DashboardView, DashboardPresenter>(), DashboardView {
    override fun createPresenter(): DashboardPresenter = DashboardPresenterImpl(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.dashboard_fragment, container, false)
        requireFragmentManager().beginTransaction().add(R.id.card_layout, ArenaCardFragment()).commit()
        requireFragmentManager().beginTransaction().add(R.id.card_layout, ArenaCardFragment()).commit()
        return view
    }
}