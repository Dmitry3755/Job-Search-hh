package com.example.jobsearch.di.components

import android.app.Application
import com.example.data.network.di.provides_repository.DataProvidesModule
import com.example.data.room.di.modules.RoomModule
import com.example.data.room.di.provides_repository.RoomRepositoriesProvidesModule
import com.example.jobsearch.di.application.JobSearchApplication
import com.example.jobsearch.di.module.AppModule
import com.example.jobsearch.di.module.NetworkModule
import com.example.jobsearch.di.module.ViewModelModule
import dagger.BindsInstance
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
        NetworkModule::class,
        DataProvidesModule::class,
        RoomRepositoriesProvidesModule::class,
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class]
)
interface AppComponent : AndroidInjector<JobSearchApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): AppComponent.Builder
        fun build(): AppComponent
    }
}