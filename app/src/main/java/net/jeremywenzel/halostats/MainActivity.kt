package net.jeremywenzel.halostats

import android.os.Bundle
import net.jwenzel.coremvp.BaseActivity
import net.jwenzel.dashboard.dashboard.DashboardFragment

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startFragment(DashboardFragment(), shouldAddToBackStack = false)
    }
}
