package com.example.data.room.converters.vacancies

import androidx.room.TypeConverter
import com.example.data.room.converters.GsonConverter
import com.google.gson.reflect.TypeToken

class SchedulesDataConverter : GsonConverter {
    @TypeConverter
    fun fromSchedulesDataConverter(schedule: List<String>): String {
        return gson.toJson(schedule)
    }

    @TypeConverter
    fun toSchedulesDataConverter(json: String): List<String> {
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(json, type)
    }
}