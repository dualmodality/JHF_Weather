package com.example.jhf_weather.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jhf_weather.models.DayForecast
import com.squareup.moshi.Moshi
import retrofit2.Retrofit

class ForecastViewModel(myMoshi: Moshi, myRetrofit: Retrofit): ViewModel() {
    val forecast: MutableLiveData<DayForecast> = MutableLiveData()
    //NEED TO IMPLEMENT AS A LIST OF FORECASTS IN THE MODEL?

    fun loadForecast() {
        // Make asynch API call to fetch forecast list
    }
}