package net.jeremywenzel.halostats

interface BasePresenter {
    fun onStart()
    fun onResume()
    fun onPause()
    fun onStop()
    fun onDestroyView()
    fun onDestroy()
}
