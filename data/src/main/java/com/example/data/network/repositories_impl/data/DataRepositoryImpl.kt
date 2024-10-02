package com.example.data.network.repositories_impl.data

import com.example.data.mappers.toData
import com.example.data.network.api.Api
import com.example.domain.network.data.repositories.DataRepositoryApi
import com.example.domain.utils.StateResponse
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(private val api: Api) : DataRepositoryApi {

    override fun loadData() = flow {
        try {
            val result = api.getAllData(
                id = "1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r",
                export = "download"
            )
            if (result.isSuccessful) {
                emit(StateResponse.Success(result.body()!!.toData(true)))
            } else {
                emit(StateResponse.Error(result.errorBody().toString()))
            }
        } catch (e: Exception) {
            emit(StateResponse.Error(e.message.toString()))
        }
    }
}