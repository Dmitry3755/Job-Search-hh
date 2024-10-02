package com.example.jobsearch.di.module

import android.app.Application
import com.example.jobsearch.utils.NetworkMonitor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideNetworkMonitor(context: Application): NetworkMonitor = NetworkMonitor(context)
}