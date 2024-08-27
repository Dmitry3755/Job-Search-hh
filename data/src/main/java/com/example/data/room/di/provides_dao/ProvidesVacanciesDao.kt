package com.example.data.room.di.provides_dao

import com.example.data.room.app_db.AppDatabase
import com.example.data.room.dao.VacanciesDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ProvidesVacanciesDao {
    @Provides
    @Singleton
    fun provideVacanciesDao(appDatabase: AppDatabase): VacanciesDao {
        return appDatabase.vacanciesDao()
    }
}