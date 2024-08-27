package com.example.data.mappers

import com.example.data.entities.ApiResponse
import com.example.data.entities.auxiliary_entities.AddressData
import com.example.domain.entities.Data
import com.example.domain.entities.auxiliary_entities.Address

fun ApiResponse.toData(): Data {
    return Data(
        offers = this.offers.map { it.toOffers() },
        vacancies = this.vacancies.map { it.toVacancies() }
    )

}