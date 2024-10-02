package com.example.data.room.converters.data

import androidx.room.TypeConverter
import com.example.data.entities.OffersData
import com.example.data.room.converters.GsonConverter
import com.example.domain.entities.Offers
import com.google.gson.reflect.TypeToken

class OffersDataConverter : GsonConverter {
    @TypeConverter
    fun fromOffersDataConverter(offersData: List<OffersData>): String {
        return gson.toJson(offersData)
    }

    @TypeConverter
    fun toOffersDataConverter(json: String): List<OffersData> {
        val type = object : TypeToken<List<OffersData>>() {}.type
        return gson.fromJson(json, type)
    }
}