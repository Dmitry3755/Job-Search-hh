package com.example.domain.entities

data class Data(
    var id: Int,
    var offers: List<Offers>,
    var vacancies : List<Vacancies>
)