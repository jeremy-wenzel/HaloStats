package net.jwenzel.coremvp.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import net.jeremywenzel.halostats.core.util.Logger
import net.jwenzel.coremvp.BaseActivity
import java.lang.IllegalStateException

abstract class BaseMvpFragment<V : BaseView, P : BasePresenter<V>> : BaseView, Fragment() {

    protected lateinit var mPresenter: P
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = createPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mPresenter.attachView(this as V)
        getBaseActivity().setBackButton(shouldShowBackButton)
        return null
    }

    protected fun getBaseActivity(): BaseActivity {
        if (activity == null || activity !is BaseActivity) {
            throw IllegalStateException("BaseActivity is null")
        }

        return activity as BaseActivity
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
        mPresenter.onStop()
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

    /**
     * Should the fragment show the back button
     */
    open val shouldShowBackButton: Boolean = false
}
