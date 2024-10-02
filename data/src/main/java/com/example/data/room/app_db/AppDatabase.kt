package com.example.data.room.app_db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.entities.ApiResponse
import com.example.data.entities.OffersData
import com.example.data.entities.VacanciesData
import com.example.data.room.dao.LocalDataDao

@Database(
    entities = [VacanciesData::class, OffersData::class, ApiResponse::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dataDao(): LocalDataDao
}