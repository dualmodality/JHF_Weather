package com.example.jhf_weather.models

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET(value = "weather")
    suspend fun getCurrentConditions(
        @Query(value = "zip") zip: String = "55119",
        @Query(value = "units") units: String = "imperial",
        @Query(value = "appid") appid: String = "2ba6a68c2752676b1f6a031bb637be59"
    ) : CurrentConditions
}

@Module
@InstallIn(ActivityComponent::class)
object Api {
    @Provides
    fun provideCurrentConditions(): CurrentConditions {
        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .build()
            .create(CurrentConditions::class.java)
    }
}