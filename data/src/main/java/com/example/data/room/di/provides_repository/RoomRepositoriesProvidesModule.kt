package com.example.data.room.di.provides_repository

import com.example.data.room.di.modules.RoomModule
import com.example.data.room.repositories_impl.LocalDataRepositoryImpl
import com.example.domain.room.data.repository.LocalDataRepositoryDb
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [RoomModule::class])
class RoomRepositoriesProvidesModule {

    @Provides
    @Singleton
    fun provideLocalDataRepository(localDataRepositoryImpl: LocalDataRepositoryImpl) : LocalDataRepositoryDb =
        localDataRepositoryImpl

}