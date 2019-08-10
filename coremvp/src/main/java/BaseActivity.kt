package net.jwenzel.coremvp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.MenuItem

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }

    fun startFragment(fragment: Fragment, shouldAddToBackStack: Boolean = true) {
        val fragmentTransaction = supportFragmentManager.beginTransaction().replace(R.id.main_activity_fragment_container, fragment)
        if (shouldAddToBackStack) {
            fragmentTransaction.addToBackStack(null)
        }
        fragmentTransaction.commit()
    }

    fun setBackButton(shouldShowBackButton: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(shouldShowBackButton)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home ->  {
                handleBackButtonPress()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun handleBackButtonPress() {
        supportFragmentManager.popBackStack()
    }
}
