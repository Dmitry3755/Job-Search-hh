package com.example.jobsearch.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.entities.Vacancies
import javax.inject.Inject

class VacanciesViewModel @Inject constructor() : ViewModel() {
    var vacancies: MutableLiveData<List<Vacancies>> = MutableLiveData()
    var favoritesVacancies: MutableLiveData<MutableList<Vacancies>> = MutableLiveData(mutableListOf())

    fun getFavoritesVacancies() {
        vacancies.value?.let { vacancyList ->
            val favoriteList = vacancyList.filter { it.isFavorite == true }
            favoritesVacancies.value = favoriteList.toMutableList()
        }
    }
}