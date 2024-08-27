package com.example.data.mappers

import com.example.data.entities.OffersData
import com.example.domain.entities.Offers

fun OffersData.toOffers(): Offers {
    return Offers(
        id = this.id,
        title = this.title,
        link = this.link,
        button = this.button?.toButton()
    )
}
