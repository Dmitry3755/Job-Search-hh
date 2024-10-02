package com.example.jobsearch.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Data
import com.example.domain.network.data.use_case.LoadDataUseCase
import com.example.domain.room.data.use_case.InsertLocalDataUseCase
import com.example.domain.room.data.use_case.LoadLocalDataUseCase
import com.example.domain.utils.StateResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class DataViewModel @Inject constructor(
    private val loadDataUseCase: LoadDataUseCase,
    private val insertLocalDataUseCase: InsertLocalDataUseCase,
    private val loadLocalDataUseCase: LoadLocalDataUseCase
) : ViewModel() {

    var data: MutableLiveData<Data> = MutableLiveData()

    fun loadNetworkData() {
        loadDataUseCase.invoke().flowOn(Dispatchers.IO).onEach {
            if (it is StateResponse.Success) {
                data.postValue(it.result)
            }
        }.launchIn(viewModelScope)
    }

    fun loadLocalData() {
        loadLocalDataUseCase.invoke().flowOn(Dispatchers.IO).onEach {
            if (it is StateResponse.Success) {
                data.postValue(it.result)
            }
        }.launchIn(viewModelScope)
    }

    fun insertLocalData() {
        insertLocalDataUseCase.invoke(data.value!!).flowOn(Dispatchers.IO).launchIn(viewModelScope)
    }
}