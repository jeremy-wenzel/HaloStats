package net.jeremywenzel.halostats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class TestMvpFragment: BaseMvpFragment<TestView, TestPresenter>(), TestView {
    override fun createPresenter(): TestPresenter {
        return TestPresenterImpl()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.test_view, container, false)
        return view
    }
}