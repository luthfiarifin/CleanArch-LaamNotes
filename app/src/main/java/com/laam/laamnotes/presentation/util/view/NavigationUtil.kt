package com.laam.laamnotes.presentation.util.view

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

object NavigationUtil {

    fun <T> Fragment.getNavigationResult(key: String = "result") =
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<T>(key)

    fun <T> Fragment.setNavigationResult(result: T, key: String = "result") {
        findNavController().previousBackStackEntry?.savedStateHandle?.set(key, result)
    }
}