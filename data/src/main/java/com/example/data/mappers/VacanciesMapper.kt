package com.example.data.mappers

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.data.entities.VacanciesData
import com.example.data.utils.formatDate
import com.example.domain.entities.Vacancies

fun VacanciesData.toVacancies(format: Boolean): Vacancies {
   return when(format) {
        true -> Vacancies(
            id = this.id,
            lookingNumber = this.lookingNumber,
            title = this.title,
            address = this.address!!.toAddress(),
            company = this.company,
            experience = this.experience!!.toExperience(),
            publishedDate = formatDate(this.publishedDate!!),
            isFavorite = this.isFavorite,
            salary = this.salary!!.toSalary(),
            schedules = this.schedules,
            appliedNumber = this.appliedNumber,
            description = this.description,
            responsibilities = this.responsibilities,
            questions = this.questions
        )
       false ->  return Vacancies(
           id = this.id,
           lookingNumber = this.lookingNumber,
           title = this.title,
           address = this.address!!.toAddress(),
           company = this.company,
           experience = this.experience!!.toExperience(),
           publishedDate = this.publishedDate!!,
           isFavorite = this.isFavorite,
           salary = this.salary!!.toSalary(),
           schedules = this.schedules,
           appliedNumber = this.appliedNumber,
           description = this.description,
           responsibilities = this.responsibilities,
           questions = this.questions
       )
    }
}


fun Vacancies.toVacanciesData(): VacanciesData {
    return VacanciesData(
        id = this.id,
        lookingNumber = this.lookingNumber,
        title = this.title,
        address = this.address!!.toAddressData(),
        company = this.company,
        experience = this.experience!!.toExperienceData(),
        publishedDate = this.publishedDate!!,
        isFavorite = this.isFavorite,
        salary = this.salary.toSalaryData(),
        schedules = this.schedules,
        appliedNumber = this.appliedNumber,
        description = this.description,
        responsibilities = this.responsibilities,
        questions = this.questions
    )
}