package com.example.data.network.di.provides_api

import com.example.data.network.api.Api
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ProvidesApi {
    @Provides
    fun provideApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }
}