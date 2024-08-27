package com.example.data.room.app_db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.entities.OffersData
import com.example.data.entities.VacanciesData
import com.example.data.room.dao.OffersDao
import com.example.data.room.dao.VacanciesDao

@Database(
    entities = [VacanciesData::class, OffersData::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun vacanciesDao(): VacanciesDao
    abstract fun offersDao() : OffersDao
}