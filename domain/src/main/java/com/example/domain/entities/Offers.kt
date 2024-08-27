package com.example.domain.entities

import com.example.domain.entities.auxiliary_entities.Button

data class Offers(
    val id : String?,
    val title : String?,
    val link : String?,
    val button : Button?
)