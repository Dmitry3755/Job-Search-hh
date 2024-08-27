package com.example.data.mappers

import com.example.data.entities.VacanciesData
import com.example.domain.entities.Vacancies

fun VacanciesData.toVacancies(): Vacancies {
    return Vacancies(
        id = this.id,
        lookingNumber = this.lookingNumber,
        title = this.title,
        address = this.address!!.toAddress(),
        company = this.company,
        experience = this.experience!!.toExperience(),
        publishedDate = this.publishedDate,
        isFavorite = this.isFavorite,
        salary = this.salary!!.toSalary(),
        schedules = this.schedules,
        appliedNumber = this.appliedNumber,
        description = this.description,
        responsibilities = this.responsibilities,
        questions = this.questions
    )
}