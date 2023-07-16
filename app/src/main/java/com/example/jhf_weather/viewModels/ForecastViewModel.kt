package com.example.jhf_weather.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jhf_weather.models.DayForecast
import com.squareup.moshi.Moshi
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Retrofit
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(private val myRetrofit: Retrofit, private val myMoshi: Moshi): ViewModel() {
    val forecast: MutableLiveData<DayForecast> = MutableLiveData()
    //NEED TO IMPLEMENT AS A LIST OF FORECASTS IN THE MODEL?

    fun loadForecast() {
        // Make asynch API call to fetch forecast list
    }
}