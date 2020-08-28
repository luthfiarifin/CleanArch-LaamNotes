package com.laam.laamnotes.framework.di.builder

import com.laam.laamnotes.presentation.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(
        modules = [MainFragmentBuilder::class]
    )
    abstract fun contributeMainActivity(): MainActivity
}