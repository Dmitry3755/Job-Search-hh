package com.example.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.entities.ApiResponse

@Dao
interface LocalDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(apiResponse: ApiResponse)

    @Query("SELECT * FROM data")
    fun getLocalData() : ApiResponse
}