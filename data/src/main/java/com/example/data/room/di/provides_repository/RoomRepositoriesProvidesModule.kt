package com.example.data.room.di.provides_repository

import com.example.data.room.di.modules.RoomModule
import com.example.data.room.repositories_impl.VacanciesRepositoryImpl
import com.example.domain.room.vacancies.repository.VacanciesRepositoryDb
import dagger.Module
import dagger.Provides
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = [RoomModule::class])
class RoomRepositoriesProvidesModule {

    @Provides
    fun provideVacanciesRepository(vacanciesRepositoryImpl: VacanciesRepositoryImpl): VacanciesRepositoryDb =
        vacanciesRepositoryImpl

}