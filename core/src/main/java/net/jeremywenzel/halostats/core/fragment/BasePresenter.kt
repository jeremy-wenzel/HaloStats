package net.jeremywenzel.halostats.core.fragment

interface BasePresenter<V : BaseView> {
    fun attachView(view: V)
    fun onStart()
    fun onResume()
    fun onPause()
    fun onStop()
    fun onDestroyView()
    fun onDestroy()
}