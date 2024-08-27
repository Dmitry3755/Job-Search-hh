package com.example.data.room.repositories_impl

import com.example.data.room.dao.VacanciesDao
import com.example.domain.entities.Vacancies
import com.example.domain.room.vacancies.repository.VacanciesRepositoryDb
import javax.inject.Inject

class VacanciesRepositoryImpl @Inject constructor(private val vacanciesDao: VacanciesDao) :
    VacanciesRepositoryDb {

    override fun insert(vacancies: Vacancies) {
       // vacanciesDao.insert()
    }
}