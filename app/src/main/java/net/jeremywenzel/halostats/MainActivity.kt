package net.jeremywenzel.halostats

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = TestMvpFragment()
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().add(R.id.main_activity_fragment_container, fragment).commit()
    }
}
