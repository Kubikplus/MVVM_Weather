package com.example.dp_infotech.presentation.details

import com.example.dp_infotech.data.model.city.City
import com.example.dp_infotech.data.model.weather.Weather

data class WeatherDetailState(
    val isLoading: Boolean = false,
    val city: City? = null,
    val error: String = "",
    val weatherInfo: Weather? = null
)
