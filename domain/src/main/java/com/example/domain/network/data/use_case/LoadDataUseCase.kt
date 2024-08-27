package com.example.domain.network.data.use_case

import com.example.domain.network.data.repositories.DataRepositoryApi
import javax.inject.Inject

class LoadDataUseCase @Inject constructor(private val dataRepositoryApi: DataRepositoryApi) {
    operator fun invoke() = dataRepositoryApi.loadData()
}