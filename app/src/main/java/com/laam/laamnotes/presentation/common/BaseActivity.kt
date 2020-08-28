package com.laam.laamnotes.presentation.common

import android.os.Bundle
import android.os.PersistableBundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.laam.laamnotes.framework.di.util.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<VB : ViewDataBinding, VM : ViewModel> : DaggerAppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProviderFactory

    private lateinit var mViewBinding: VB
    private lateinit var mViewModel: VM

    val viewBinding
        get() = mViewBinding

    val viewModel
        get() = mViewModel

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        mViewBinding = DataBindingUtil.setContentView(this, getLayoutId())
        mViewModel = ViewModelProvider(this, factory)[getViewModel()]
    }

    abstract fun getViewModel(): Class<VM>

    abstract fun getLayoutId(): Int
}