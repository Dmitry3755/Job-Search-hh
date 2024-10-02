package com.example.domain.room.data.use_case

import com.example.domain.entities.Data
import com.example.domain.room.data.repository.LocalDataRepositoryDb
import javax.inject.Inject

class InsertLocalDataUseCase @Inject constructor(private val localDataRepositoryDb: LocalDataRepositoryDb) {
    operator fun invoke(data : Data) = localDataRepositoryDb.insertLocalData(data)
}