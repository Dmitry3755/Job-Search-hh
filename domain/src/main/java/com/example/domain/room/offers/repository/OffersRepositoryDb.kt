package com.example.domain.room.offers.repository

import com.example.domain.entities.Offers

interface OffersRepositoryDb {

    fun insert(offers: Offers)

}