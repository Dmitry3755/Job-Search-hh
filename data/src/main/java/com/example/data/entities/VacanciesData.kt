package com.example.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.data.entities.auxiliary_entities.AddressData
import com.example.data.entities.auxiliary_entities.ExperienceData
import com.example.data.entities.auxiliary_entities.SalaryData
import com.example.data.room.converters.vacancies.AddressDataConverter
import com.example.data.room.converters.vacancies.ExperienceDataConverter
import com.example.data.room.converters.vacancies.SalaryDataConverter
import com.example.data.room.converters.vacancies.SchedulesDataConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "vacancies")
@TypeConverters(
    AddressDataConverter::class,
    ExperienceDataConverter::class,
    SalaryDataConverter::class,
    SchedulesDataConverter::class
)
data class VacanciesData(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo("id")
    @SerializedName("id")
    val id: String,
    @ColumnInfo("looking_number")
    @SerializedName("lookingNumber")
    val lookingNumber: Int?,
    @ColumnInfo("title")
    @SerializedName("title")
    val title: String?,
    @ColumnInfo("address")
    @SerializedName("address")
    val address: AddressData?,
    @ColumnInfo("company")
    @SerializedName("company")
    val company: String?,
    @ColumnInfo("experience")
    @SerializedName("experience")
    val experience: ExperienceData?,
    @ColumnInfo("published_date")
    @SerializedName("publishedDate")
    val publishedDate: String?,
    @ColumnInfo("favorite")
    @SerializedName("isFavorite")
    val isFavorite: Boolean?,
    @ColumnInfo("salary")
    @SerializedName("salary")
    val salary: SalaryData?,
    @ColumnInfo("schedules")
    @SerializedName("schedules")
    val schedules: List<String>?,
    @ColumnInfo("applied_number")
    @SerializedName("appliedNumber")
    val appliedNumber: Int?,
    @ColumnInfo("description")
    @SerializedName("description")
    val description: String?,
    @ColumnInfo("responsibilities")
    @SerializedName("responsibilities")
    val responsibilities: String?,
    @ColumnInfo("questions")
    @SerializedName("questions")
    val questions: List<String>?
)