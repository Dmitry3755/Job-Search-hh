package com.example.data.room.converters.offers

import androidx.room.TypeConverter
import com.example.data.entities.auxiliary_entities.ButtonData
import com.example.data.room.converters.GsonConverter
import com.google.gson.reflect.TypeToken

class ButtonDataConverter : GsonConverter {
    @TypeConverter
    fun fromButtonDataConverter(button: ButtonData) : String {
        return gson.toJson(button)
    }
    @TypeConverter
    fun toButtonDataConverter(json: String) : ButtonData {
        val type = object : TypeToken<ButtonData>() {}.type
        return gson.fromJson(json, type)
    }
}