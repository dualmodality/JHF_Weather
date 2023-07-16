package com.example.jhf_weather.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jhf_weather.models.Api
import com.example.jhf_weather.models.CurrentConditions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class CurrentConditionsViewModel @Inject constructor(private val service: Api) : ViewModel() {

    val currentConditions: MutableLiveData<CurrentConditions> = MutableLiveData()

    fun loadData() = runBlocking {
        launch { currentConditions.value = service.getCurrentConditions(zip = "55119") }
    }

}