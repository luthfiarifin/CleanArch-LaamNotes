package com.laam.laamnotes.presentation.main

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.laam.laamnotes.R
import com.laam.laamnotes.databinding.ActivityMainBinding
import com.laam.laamnotes.presentation.common.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainNavigator {
    override fun getViewModel(): Class<MainViewModel> = MainViewModel::class.java

    override fun getLayoutId(): Int = R.layout.activity_main

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.setNavigator(this)
        setUpNavigation()
    }

    private fun setUpNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment

        navController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean =
        NavigationUI.navigateUp(navController, null)
}