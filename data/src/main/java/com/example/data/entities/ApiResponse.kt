package com.example.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.data.room.converters.data.OffersDataConverter
import com.example.data.room.converters.data.VacanciesDataConverter

@Entity(tableName = "data")
@TypeConverters(OffersDataConverter::class, VacanciesDataConverter::class)
data class ApiResponse(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo("offers")
    var offers: List<OffersData>,
    @ColumnInfo("vacancies")
    var vacancies: List<VacanciesData>
)