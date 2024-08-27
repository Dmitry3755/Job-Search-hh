package com.example.domain.room.offers.use_case

import com.example.domain.entities.Offers
import com.example.domain.room.offers.repository.OffersRepositoryDb
import javax.inject.Inject

class InsertOffersUseCaseDb @Inject constructor(private val offersRepository: OffersRepositoryDb) {
    fun invoke(offers: Offers) = offersRepository.insert(offers)
}