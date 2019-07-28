package net.jeremywenzel.halostats.features

import net.jwenzel.coremvp.fragment.BasePresenterImpl

class TestPresenterImpl(view: TestView): TestPresenter, BasePresenterImpl<TestView>(view) {
}