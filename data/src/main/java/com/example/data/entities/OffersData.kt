package com.example.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.data.entities.auxiliary_entities.ButtonData
import com.example.data.room.converters.offers.ButtonDataConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "offers")
@TypeConverters(ButtonDataConverter::class)
data class OffersData(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo("id")
    @SerializedName("id")
    val id : String,
    @ColumnInfo("title")
    @SerializedName("title")
    val title : String?,
    @ColumnInfo("link")
    @SerializedName("link")
    val link : String?,
    @ColumnInfo("button_text")
    @SerializedName("button")
    val button : ButtonData?
)