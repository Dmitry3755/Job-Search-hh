package com.example.domain.entities

import com.example.domain.entities.auxiliary_entities.Address
import com.example.domain.entities.auxiliary_entities.Experience
import com.example.domain.entities.auxiliary_entities.Salary

data class Vacancies(
    val id: String,
    val lookingNumber: Int?,
    val title: String?,
    val address: Address?,
    val company: String?,
    val experience: Experience?,
    val publishedDate: String?,
    val isFavorite: Boolean?,
    val salary: Salary,
    val schedules: List<String>?,
    val appliedNumber: Int?,
    val description: String?,
    val responsibilities: String?,
    val questions: List<String>?
)