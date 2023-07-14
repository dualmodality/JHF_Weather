package com.example.jhf_weather.models

import com.squareup.moshi.Json

data class CurrentConditions(
    @Json(name = "name") val locName: String,
    val icon: String,
    val temp: Float,
    @Json(name = "feels_like") val feelsLike: Float,
    @Json(name = "temp_min") val tempMin: Float,
    @Json(name = "temp_max") val tempMax: Float,
    val pressure: Int,
    val humidity: Int

)
