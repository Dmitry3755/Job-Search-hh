package com.example.data.mappers

import com.example.data.entities.auxiliary_entities.ButtonData
import com.example.domain.entities.auxiliary_entities.Button

fun ButtonData.toButton(): Button {
    return Button(
        text = this.text
    )
}

fun Button.toButtonData(): ButtonData {
    return ButtonData(
        text = this.text
    )
}