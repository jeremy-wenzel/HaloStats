package net.jeremywenzel.halostats

import android.os.Bundle
import android.support.v4.app.Fragment

abstract class BaseMvpFragment<P : BasePresenter>: BaseView, Fragment() {

    private lateinit var mPresenter: BasePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = createPresenter()
    }

    internal abstract fun createPresenter(): P

    override fun onStart() {
        super.onStart()
        mPresenter.onStart()
    }

    override fun onResume() {
        super.onResume()
        mPresenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        mPresenter.onPause()
    }

    override fun onStop() {
        super.onStop()
        mPresenter.onStart()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mPresenter.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }
}
