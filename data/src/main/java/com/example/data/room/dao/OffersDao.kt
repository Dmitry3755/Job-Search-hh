package com.example.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.data.entities.VacanciesData

@Dao
interface OffersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vacanciesData: VacanciesData)
}