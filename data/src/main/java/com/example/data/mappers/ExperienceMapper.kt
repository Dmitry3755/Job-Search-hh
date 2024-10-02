package com.example.data.mappers

import com.example.data.entities.auxiliary_entities.ExperienceData
import com.example.domain.entities.auxiliary_entities.Experience

fun ExperienceData.toExperience() : Experience {
    return Experience(
        previewText = this.previewText,
        text = this.text
    )
}

fun Experience.toExperienceData() : ExperienceData {
    return ExperienceData(
        previewText = this.previewText,
        text = this.text
    )
}