package com.example.dp_infotech.domain.usecases

import com.example.dp_infotech.domain.repository.WeatherRepository
import javax.inject.Inject

class GetWeather @Inject constructor(private val repository: WeatherRepository) {
    suspend operator fun invoke(lon:Double,lat:Double){
        repository.getWeatherData(long = lon, lat = lat)
    }
}