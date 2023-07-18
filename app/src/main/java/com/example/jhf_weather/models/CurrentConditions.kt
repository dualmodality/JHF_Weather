package com.example.jhf_weather.models

import com.squareup.moshi.Json

data class CurrentConditions(
    @Json(name = "weather") private val weatherSummary : WeatherSummary,
    @Json(name = "main") private val weatherData : WeatherData,
    @Json(name = "name") val locationName : String
) {
    val weatherIcon : String
        get() = weatherSummary.icon
    val weatherDescription : String
        get() = weatherSummary.description
    val currentTemp : Float
        get() = weatherData.currentTemp
    val feelsLike : Float
        get() = weatherData.feelsLike
    val pressure : Int
        get() = weatherData.pressure
    val humidity : Int
        get() = weatherData.humidity
    val maxTemp : Float
        get() = weatherData.maxTemp
    val minTemp : Float
        get() = weatherData.minTemp
}

data class WeatherSummary(
    val description : String,
    val icon : String

)

data class WeatherData(
    @Json(name = "temp") val currentTemp : Float,
    @Json(name = "feels_like") val feelsLike : Float,
    val pressure : Int,
    val humidity : Int,
    @Json(name = "temp_min") val minTemp : Float,
    @Json(name = "temp_max") val maxTemp : Float
)