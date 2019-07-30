package net.jwenzel.dashboard.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import net.jwenzel.coremvp.fragment.BaseMvpFragment
import net.jwenzel.dashboard.R

abstract class DashboardCardFragment<V: DashboardCardView, P: DashboardCardPresenter<V>>: BaseMvpFragment<V, P>(), DashboardCardView {
    private lateinit var titleView: TextView
    private lateinit var cardView: View
    private lateinit var cardContainer: ViewGroup

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.dashboard_card_fragment, container, false)
        titleView = view.findViewById(R.id.card_title)
        titleView.text = getString(getCardTitleId())

        val cardView = inflater.inflate(getCardLayoutId(), container, false)
        cardContainer = view.findViewById(R.id.card_container)
        cardContainer.removeAllViews()
        cardContainer.addView(cardView)

        return view
    }

    /**
     * Gets the child card layout to be displayed. This layout will be inflated
     * by the [DashboardCardFragment]
     */
    protected abstract fun getCardLayoutId(): Int

    /**
     * Gets the title string res id of the card to be displayed
     */
    protected abstract fun getCardTitleId(): Int
}