package com.example.dp_infotech.data.remote

import com.example.dp_infotech.data.model.weather.Weather
import com.example.dp_infotech.domain.repository.WeatherRepository
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET ("weather")
    suspend  fun getWeather(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") apiKey: String,
        @Query("units") units:String
    ):Weather
}