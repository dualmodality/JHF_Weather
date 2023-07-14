package com.example.jhf_weather.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jhf_weather.models.CurrentConditions
import com.squareup.moshi.Moshi
import retrofit2.Retrofit

class CurrentConditionsViewModel(myMoshi: Moshi, myRetrofit: Retrofit) : ViewModel() {
    val currentConditions: MutableLiveData<CurrentConditions> = MutableLiveData()

    fun loadCurrentConditions() {
        // Make asynchronous API call to fetch data
    }
}