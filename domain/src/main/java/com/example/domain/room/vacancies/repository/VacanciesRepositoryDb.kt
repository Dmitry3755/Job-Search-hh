package com.example.domain.room.vacancies.repository

import com.example.domain.entities.Vacancies

interface VacanciesRepositoryDb {

    fun insert(vacancies: Vacancies)

}