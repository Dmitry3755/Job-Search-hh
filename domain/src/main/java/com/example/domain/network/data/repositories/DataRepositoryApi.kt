package com.example.domain.network.data.repositories

import com.example.domain.entities.Data
import com.example.domain.utils.StateResponse
import kotlinx.coroutines.flow.Flow

interface DataRepositoryApi {
    fun loadData() : Flow<StateResponse<Data>>
}