package com.example.jobsearch.di.components

import com.example.data.network.di.provides_repository.DataProvidesModule
import com.example.data.room.di.modules.RoomModule
import com.example.jobsearch.di.application.JobSearchApplication
import com.example.jobsearch.di.module.AppModule
import com.example.jobsearch.di.module.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RoomModule::class,
        ViewModelModule::class,
        AppModule::class,
        DataProvidesModule::class,
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class]
)
interface AppComponent : AndroidInjector<JobSearchApplication> {

    @Component.Builder
    interface Builder {

        fun build(): AppComponent

    }

}