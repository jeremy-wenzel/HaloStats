package net.jeremywenzel.halostats.features

import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.jeremywenzel.halostats.R
import net.jwenzel.coremvp.fragment.BaseMvpFragment

class TestMvpFragment: BaseMvpFragment<TestView, TestPresenter>(), TestView {
    override fun createPresenter(): TestPresenter {
        return TestPresenterImpl(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.test_view, container, false)
        return view
    }

    override fun onStart() {
        super.onStart()
        TestAsync().execute()
    }

    private class TestAsync: AsyncTask<Void, Void, Void?>() {
        override fun doInBackground(vararg p0: Void?): Void? {
//            RequestProcessor.makeRequest(EnemiesRequest())
            return null
        }
    }
}