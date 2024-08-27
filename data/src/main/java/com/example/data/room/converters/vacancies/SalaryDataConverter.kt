package com.example.data.room.converters.vacancies

import androidx.room.TypeConverter
import com.example.data.entities.auxiliary_entities.SalaryData
import com.example.data.room.converters.GsonConverter
import com.google.gson.reflect.TypeToken

class SalaryDataConverter : GsonConverter {
    @TypeConverter
    fun fromSalaryDataConverter(salaryData: SalaryData): String {
        return gson.toJson(salaryData)
    }

    @TypeConverter
    fun toSalaryDataConverter(json: String) : SalaryData {
        val type = object : TypeToken<SalaryData>() {}.type
        return gson.fromJson(json, type)
    }

}