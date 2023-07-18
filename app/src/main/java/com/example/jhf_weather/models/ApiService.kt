package com.example.jhf_weather.models

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/{callPath}")

    suspend fun getCurrentConditions(
        @Path("callPath") request: String = "weather",
        @Query(value = "zip") zip: String = "55119,us",
        @Query(value = "units") units: String = "imperial",
        @Query(value = "appid") appid: String = "2ba6a68c2752676b1f6a031bb637be59"
    ) : CurrentConditions

    suspend fun getForecast(
        @Path("callPath") request: String = "forecast/daily",
        @Query(value = "zip") zip: String = "55119,us",
        @Query(value = "units") units: String = "imperial",
        @Query(value = "cnt") count: Int = 16,
        @Query(value = "appid") appid: String = "2ba6a68c2752676b1f6a031bb637be59"
    ) : MultiForecast

}
