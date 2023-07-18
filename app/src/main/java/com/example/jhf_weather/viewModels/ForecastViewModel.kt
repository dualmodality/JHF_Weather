package com.example.jhf_weather.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jhf_weather.models.ApiService
import com.example.jhf_weather.models.MultiForecast
import com.squareup.moshi.Moshi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(private val apiService: ApiService): ViewModel() {
    private val _multiForecast: MutableLiveData<MultiForecast> = MutableLiveData()
    val multiForecast: LiveData<MultiForecast>
        get() = _multiForecast

    fun viewAppeared() = viewModelScope.launch {
        _multiForecast.value = apiService.getForecast()
    }
}