package com.example.data.entities.auxiliary_entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

data class ExperienceData(
    @SerializedName("previewText")
    val previewText: String?,
    @SerializedName("text")
    val text: String?,
)