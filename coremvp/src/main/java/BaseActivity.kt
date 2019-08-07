package net.jwenzel.coremvp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }

    fun startFragment(fragment: Fragment, shouldAddToBackStack: Boolean = false) {
        val fragmentTransaction = supportFragmentManager.beginTransaction().replace(R.id.main_activity_fragment_container, fragment)
        if (shouldAddToBackStack) {
            fragmentTransaction.addToBackStack(null)
        }
        fragmentTransaction.commit()
    }
}
