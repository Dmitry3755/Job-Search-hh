package com.example.domain.room.vacancies.use_case

import com.example.domain.entities.Vacancies
import com.example.domain.room.vacancies.repository.VacanciesRepositoryDb
import javax.inject.Inject

class InsertVacanciesUseCaseDb @Inject constructor(private val vacanciesRepositoryDb: VacanciesRepositoryDb) {
    fun invoke(vacancies: Vacancies) = vacanciesRepositoryDb.insert(vacancies)
}