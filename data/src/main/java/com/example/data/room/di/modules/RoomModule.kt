package com.example.data.room.di.modules

import android.content.Context
import androidx.room.Room
import com.example.data.room.app_db.AppDatabase
import com.example.data.room.di.provides_dao.ProvidesVacanciesDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ProvidesVacanciesDao::class])
class RoomModule {
    @Singleton
    @Provides
    fun providesRoom(appContext: Context) : AppDatabase {
        return Room.databaseBuilder(
            name = "job_search.db",
            context = appContext,
            klass = AppDatabase::class.java
        ).build()
    }
}