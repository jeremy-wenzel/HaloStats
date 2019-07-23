package net.jeremywenzel.halostats.core.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import net.jeremywenzel.halostats.core.util.Logger

abstract class BaseMvpFragment<V: BaseView, P : BasePresenter<V>>: BaseView, Fragment() {

    private lateinit var mPresenter: BasePresenter<V>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = createPresenter()
    }

    protected abstract fun createPresenter(): P

    override fun onStart() {
        super.onStart()
        Logger.d("in onStart")
        mPresenter.onStart()
    }

    override fun onResume() {
        super.onResume()
        Logger.d("in onResume")
        mPresenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        Logger.d("in onPause")
        mPresenter.onPause()
    }

    override fun onStop() {
        super.onStop()
        Logger.d("in onStop")
        mPresenter.onStart()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Logger.d("in onDestroyView")
        mPresenter.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
        Logger.d("in onDestroy")
        mPresenter.onDestroy()
    }
}
