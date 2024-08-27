package com.example.jobsearch.ui.screens.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Data
import com.example.domain.network.data.use_case.LoadDataUseCase
import com.example.domain.utils.StateResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class DataViewModel @Inject constructor(
    private val loadDataUseCase: LoadDataUseCase
) : ViewModel() {

    var data: MutableLiveData<Data> = MutableLiveData()

    fun loadData() {
        loadDataUseCase.invoke().flowOn(Dispatchers.IO).onEach {
            if (it is StateResponse.Success) {
                data.postValue(it.result)
            }
        }.launchIn(viewModelScope)
    }

}