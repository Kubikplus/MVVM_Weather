package com.example.dp_infotech.data

import com.example.dp_infotech.data.model.weather.Weather
import com.example.dp_infotech.data.remote.WeatherAPI
import com.example.dp_infotech.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepoImpl @Inject constructor(private val api: WeatherAPI):WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Weather {
        return api.getWeather(lat,long, apiKey = "4d3f79db8a9efaf46e52c66b9a9da301", units = "metric")

    }
}