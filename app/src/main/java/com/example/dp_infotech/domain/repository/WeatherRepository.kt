package com.example.dp_infotech.domain.repository

import com.example.dp_infotech.data.model.weather.Weather
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Weather
}