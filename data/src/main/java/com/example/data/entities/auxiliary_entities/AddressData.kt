package com.example.data.entities.auxiliary_entities

import com.google.gson.annotations.SerializedName

data class AddressData(
    @SerializedName("town")
    val town: String?,
    @SerializedName("street")
    val street: String?,
    @SerializedName("house")
    val house: String?
)