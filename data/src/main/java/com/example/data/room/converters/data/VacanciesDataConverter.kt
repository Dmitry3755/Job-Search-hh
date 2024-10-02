package com.example.data.room.converters.data

import androidx.room.TypeConverter
import com.example.data.entities.VacanciesData
import com.example.data.room.converters.GsonConverter
import com.google.gson.reflect.TypeToken

class VacanciesDataConverter : GsonConverter {
    @TypeConverter
    fun fromVacanciesDataConverter(vacanciesData: List<VacanciesData>): String {
        return gson.toJson(vacanciesData)
    }

    @TypeConverter
    fun toVacanciesDataConverter(json: String): List<VacanciesData> {
        val type = object : TypeToken<List<VacanciesData>>() {}.type
        return gson.fromJson(json, type)
    }
}