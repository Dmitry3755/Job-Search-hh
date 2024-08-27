package com.example.data.room.converters.vacancies

import androidx.room.TypeConverter
import com.example.data.entities.auxiliary_entities.AddressData
import com.example.data.room.converters.GsonConverter
import com.google.gson.reflect.TypeToken

class AddressDataConverter : GsonConverter {
    @TypeConverter
    fun fromAddressDataConverter(address: AddressData): String {
        return gson.toJson(address)
    }

    @TypeConverter
    fun toAddressDataConverter(json: String): AddressData {
        val type = object : TypeToken<AddressData>() {}.type
        return gson.fromJson(json, type)
    }
}