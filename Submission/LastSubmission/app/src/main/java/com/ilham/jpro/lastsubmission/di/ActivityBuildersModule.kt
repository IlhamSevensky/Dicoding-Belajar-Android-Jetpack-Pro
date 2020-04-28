package com.ilham.jpro.lastsubmission.di

import com.ilham.jpro.lastsubmission.di.home.HomeFragmentBuildersModule
import com.ilham.jpro.lastsubmission.ui.detail.DetailActivity
import com.ilham.jpro.lastsubmission.ui.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [HomeFragmentBuildersModule::class])
    abstract fun contributeHomeActivity(): HomeActivity

    @ContributesAndroidInjector
    abstract fun contributeDetailActivity(): DetailActivity

}