package com.example.jobsearch.di.module

import com.example.jobsearch.di.scope.ActivityScope
import com.example.jobsearch.ui.activity.JobSearchActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface AppModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [FragmentsModule::class])
    fun providesJobSearchActivity():  JobSearchActivity

}