package com.example.jobsearch.di.application

import android.app.Application
import com.example.jobsearch.di.components.AppComponent
import com.example.jobsearch.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class JobSearchApplication : DaggerApplication() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        applicationInjector()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = DaggerAppComponent.builder().build()
        return appComponent
    }
}