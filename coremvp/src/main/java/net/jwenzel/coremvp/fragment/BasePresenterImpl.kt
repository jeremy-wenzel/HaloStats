package net.jwenzel.coremvp.fragment

import net.jeremywenzel.halostats.core.util.Logger
import net.jeremywenzel.halostats.webapi.RequestProcessor
import net.jeremywenzel.halostats.webapi.parsers.BaseResponseParser
import net.jeremywenzel.halostats.webapi.requests.BaseHaloRequest

abstract class BasePresenterImpl<V: BaseView>(protected var view: V?) : BasePresenter<V> {

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
        view = null
    }

    protected fun isViewNull(): Boolean {
        return view == null
    }

    protected suspend fun <T: BaseResponseParser<*>, E> sendRequest(request: BaseHaloRequest<T>, succeedAction: (result: E) -> Unit) {
        val responseObject = RequestProcessor.makeRequest<T, E>(request)

        if (responseObject.wasException) {
            // Do something here with the exception
            return
        }

        if (responseObject.responseValue == null) {
            // I feel this shouldn't happen when the request succeeds but just in case
            Logger.d("Response object was null")
            return
        }

        succeedAction(responseObject.responseValue as E)
    }
}
