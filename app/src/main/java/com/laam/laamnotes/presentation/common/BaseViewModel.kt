package com.laam.laamnotes.presentation.common

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import java.lang.ref.WeakReference

abstract class BaseViewModel<N> : ViewModel() {

    private lateinit var mNavigator: WeakReference<N>

    protected val navigator
        get() = mNavigator.get()

    fun setNavigator(navigator: N) {
        mNavigator = WeakReference(navigator)
    }

    protected val coroutineScopeIO = CoroutineScope(Dispatchers.IO)
}