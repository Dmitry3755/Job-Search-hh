package com.example.data.entities.auxiliary_entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

data class SalaryData(
    @SerializedName("full")
    val full: String?,
    @SerializedName("short")
    val short: String?
)
