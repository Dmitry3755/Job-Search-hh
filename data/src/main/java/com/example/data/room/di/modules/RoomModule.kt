package com.example.data.room.di.modules

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.data.room.app_db.AppDatabase
import com.example.data.room.dao.LocalDataDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {
    @Singleton
    @Provides
    fun providesRoom(appContext: Application) : AppDatabase {
        return Room.databaseBuilder(
            name = "job_search.db",
            context = appContext,
            klass = AppDatabase::class.java
        ).build()
    }

    @Provides
    @Singleton
    fun provideLocalDataDao(appDatabase: AppDatabase): LocalDataDao {
        return appDatabase.dataDao()
    }
}