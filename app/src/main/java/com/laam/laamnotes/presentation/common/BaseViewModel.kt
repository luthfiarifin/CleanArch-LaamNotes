package com.laam.laamnotes.presentation.common

import androidx.lifecycle.ViewModel
import java.lang.ref.WeakReference

abstract class BaseViewModel<N> : ViewModel() {

    private lateinit var mNavigator: WeakReference<N>

    val navigator
        get() = mNavigator

    fun setNavigator(navigator: N) {
        mNavigator = WeakReference(navigator)
    }
}