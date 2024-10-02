package com.example.data.room.repositories_impl

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.data.mappers.toApiResponse
import com.example.data.mappers.toData
import com.example.data.room.dao.LocalDataDao
import com.example.domain.entities.Data
import com.example.domain.room.data.repository.LocalDataRepositoryDb
import com.example.domain.utils.StateResponse
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LocalDataRepositoryImpl @Inject constructor(private val localDataDao: LocalDataDao) :
    LocalDataRepositoryDb {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun loadLocalData() = flow {
        try {
            emit(StateResponse.Success(localDataDao.getLocalData().toData(false)))
        } catch (e: Exception) {
            emit(StateResponse.Error(e.message.toString()))
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun insertLocalData(data : Data) = flow {
        localDataDao.insert(data.toApiResponse())
        emit(Unit)
    }
}