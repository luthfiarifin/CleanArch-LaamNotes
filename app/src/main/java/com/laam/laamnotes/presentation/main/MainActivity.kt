package com.laam.laamnotes.presentation.main

import android.os.Bundle
import android.os.PersistableBundle
import com.laam.laamnotes.R
import com.laam.laamnotes.databinding.ActivityMainBinding
import com.laam.laamnotes.presentation.common.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainNavigator {
    override fun getViewModel(): Class<MainViewModel> = MainViewModel::class.java

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        viewModel.setNavigator(this)
    }
}