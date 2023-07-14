package com.example.jhf_weather.models

import retrofit2.http.GET

interface CurrentConditionsService {
    @GET("weather?zip=55119,us&appid=2ba6a68c2752676b1f6a031bb637be59")
    Call<CurrentConditions> getCurrent();
}