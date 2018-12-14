package net.jeremywenzel.halostats

abstract class BasePresenterImpl<V : BaseView> : BasePresenter {
    private var mView: V? = null

    fun BasePresenterImpl(view: V) {
        mView = view
    }

    override fun onStart() {

    }

    override fun onResume() {

    }

    override fun onPause() {

    }

    override fun onStop() {

    }

    override fun onDestroy() {

    }

    override fun onDestroyView() {

    }
}
