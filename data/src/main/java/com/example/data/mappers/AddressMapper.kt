package com.example.data.mappers

import com.example.data.entities.auxiliary_entities.AddressData
import com.example.domain.entities.auxiliary_entities.Address

fun AddressData.toAddress(): Address {
    return Address(
        town = this.town,
        street = this.street,
        house = this.house
    )

}