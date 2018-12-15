package net.jeremywenzel.halostats

abstract class BasePresenterImpl<V: BaseView> : BasePresenter<V> {
    protected var mView: V? = null

    override fun attachView(view: V) {
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
        mView = null
    }

    protected fun isViewNull(): Boolean {
        return mView == null
    }
}
