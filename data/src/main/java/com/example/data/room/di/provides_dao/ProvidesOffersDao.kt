package com.example.data.room.di.provides_dao

import com.example.data.room.app_db.AppDatabase
import com.example.data.room.dao.OffersDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ProvidesOffersDao {
    @Singleton
    @Provides
    fun providesOffersDao(appDatabase: AppDatabase) : OffersDao = appDatabase.offersDao()
}