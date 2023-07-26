package com.example.jhf_weather.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jhf_weather.models.ApiService
import com.example.jhf_weather.models.CurrentConditions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrentConditionsViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {

    val userZip: MutableLiveData<String> = MutableLiveData("02139")
    private val _currentConditions: MutableLiveData<CurrentConditions> = MutableLiveData()
    val currentConditions: LiveData<CurrentConditions>
        get() = _currentConditions
    fun viewAppeared() = viewModelScope.launch {
        _currentConditions.value = apiService.getCurrentConditions(zip = userZip.value.toString() + ",us")
    }

    fun validateZip(userInput : String) {

    }


}