package net.jwenzel.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.jwenzel.coremvp.fragment.BaseMvpFragment

class ArenaCardFragment: BaseMvpFragment<ArenaCardView, ArenaCardPresenter>(), ArenaCardView {
    override fun createPresenter(): ArenaCardPresenter = ArenaCardPresenterImpl()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.arena_card_fragment, container, false)

    }
}