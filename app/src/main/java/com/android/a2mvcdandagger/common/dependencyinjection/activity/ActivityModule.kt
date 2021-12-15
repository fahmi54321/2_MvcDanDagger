package com.android.a2mvcdandagger.common.dependencyinjection.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.android.a2mvcdandagger.common.dependencyinjection.app.AppModule
import com.android.a2mvcdandagger.screens.common.navigator.ScreenNavigator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ActivityModule(
    val activity: AppCompatActivity,
    private val appModule: AppModule
) {

    //todo 2 hapus lazy initialization pada screen navigator

    @Provides
    fun application() = appModule.application

    @Provides
    fun stackoverflowApi() = appModule.stackoverflowApi(appModule.retrofit())

    @Provides
    fun activity() = activity

    //todo 3 (next ActivityComponent)
    @Provides
    @ActivityScope
    fun screenNavigator (activity: AppCompatActivity) = ScreenNavigator(activity)

    @Provides
    fun layoutInflater() = LayoutInflater.from(activity)

    @Provides
    fun fragmentManager() = activity.supportFragmentManager
}