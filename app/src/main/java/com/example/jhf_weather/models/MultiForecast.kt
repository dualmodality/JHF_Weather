package com.example.jhf_weather.models

import com.squareup.moshi.Json

data class MultiForecast(
    @Json(name = "cnt") val count: Int,
    @Json(name = "list") val forecastList: List<DayForecast>
)

data class DayForecast(
    @Json(name = "dt") val date: Long,
    val sunrise: Long,
    val sunset: Long,
    @Json(name = "temp") private val tempData: ForecastTemp,
    @Json(name = "weather") private val weatherSummary: WeatherSummary,
) {
    val daytimeTemp : Float
        get() = tempData.day
    val minTemp : Float
        get() = tempData.min
    val maxTemp : Float
        get() = tempData.max
    val weatherIcon : String
        get() = weatherSummary.icon
}

data class ForecastTemp(
    val day: Float,
    val min: Float,
    val max: Float
)
val dummyWeatherSummary = WeatherSummary("", "")
val dummyTempData = ForecastTemp(0.toFloat(), 0.toFloat(), 0.toFloat())
val dummyDayForecast = DayForecast(0,0,0, dummyTempData, dummyWeatherSummary)
val dummyList = listOf(dummyDayForecast)
val dummyForecast = MultiForecast(1, dummyList)