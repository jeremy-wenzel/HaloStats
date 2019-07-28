package net.jwenzel.coremvp.fragment

interface BasePresenter<V : BaseView> {
    fun onStart()
    fun onResume()
    fun onPause()
    fun onStop()
    fun onDestroyView()
    fun onDestroy()
}
