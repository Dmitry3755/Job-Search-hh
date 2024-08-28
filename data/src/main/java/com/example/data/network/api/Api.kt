package com.example.data.network.api

import com.example.data.entities.ApiResponse
import com.example.data.entities.OffersData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("/u/0/uc?")
    suspend fun getAllData(
        @Query("id") id: String,
        @Query("export") export: String
    ): Response<ApiResponse>
}