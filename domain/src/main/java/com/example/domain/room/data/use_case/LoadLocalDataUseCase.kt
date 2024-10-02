package com.example.domain.room.data.use_case

import com.example.domain.room.data.repository.LocalDataRepositoryDb
import javax.inject.Inject

class LoadLocalDataUseCase @Inject constructor(private val localDataRepositoryDb: LocalDataRepositoryDb) {
    operator fun invoke() = localDataRepositoryDb.loadLocalData()
}