package com.example.data.room.converters.vacancies

import androidx.room.TypeConverter
import com.example.data.entities.auxiliary_entities.ExperienceData
import com.example.data.room.converters.GsonConverter
import com.google.gson.reflect.TypeToken

class ExperienceDataConverter : GsonConverter {

    @TypeConverter
    fun fromExperienceDataConverter(experienceData: ExperienceData) : String {
        return gson.toJson(experienceData)
    }

    @TypeConverter
    fun toExperienceDataConverter(json: String) : ExperienceData {
        val type = object : TypeToken<ExperienceData>() {}.type
        return gson.fromJson(json, type)
    }

}