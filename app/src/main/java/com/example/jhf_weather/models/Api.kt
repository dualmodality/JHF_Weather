package com.example.jhf_weather.models

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