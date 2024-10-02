package com.example.data.mappers

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.data.entities.ApiResponse
import com.example.domain.entities.Data

fun ApiResponse.toData(format : Boolean): Data {
    return when(format) {
        true -> Data(
            id = this.id,
            offers = this.offers.map { it.toOffers() },
            vacancies = this.vacancies.map { it.toVacancies(true) }
        )
        false-> Data(
            id = this.id,
            offers = this.offers.map { it.toOffers() },
            vacancies = this.vacancies.map { it.toVacancies(false) }
        )
    }
}

fun Data.toApiResponse(): ApiResponse {
    return ApiResponse(
        id = this.id,
        offers = this.offers.map { it.toOffersData() },
        vacancies = this.vacancies.map { it.toVacanciesData() }
    )
}