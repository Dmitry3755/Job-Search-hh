package com.example.data.network.di.provides_repository

import com.example.data.network.di.modules.RetrofitModule
import com.example.data.network.repositories_impl.data.DataRepositoryImpl
import com.example.domain.network.data.repositories.DataRepositoryApi
import dagger.Module
import dagger.Provides

@Module(includes = [RetrofitModule::class])
class DataProvidesModule {
    @Provides
    fun providesDataRepositoryApi(dataRepositoryImpl: DataRepositoryImpl): DataRepositoryApi =
        dataRepositoryImpl
}