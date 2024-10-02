package com.example.domain.room.data.repository

import com.example.domain.entities.Data
import com.example.domain.utils.StateResponse
import kotlinx.coroutines.flow.Flow

interface LocalDataRepositoryDb {
    fun loadLocalData(): Flow<StateResponse<Data>>
    fun insertLocalData(data : Data) : Flow<Unit>
}