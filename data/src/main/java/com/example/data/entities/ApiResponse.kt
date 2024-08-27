package com.example.data.entities

data class ApiResponse(
    var offers: List<OffersData>,
    var vacancies : List<VacanciesData>
)