package com.example.dp_infotech.presentation.main

import com.example.dp_infotech.data.model.city.City

data class WeatherState(
    var cities:List<City> = emptyList(),
    val filteredCities: List<City> = emptyList(),
    val searchQuery: String = "",
    var isLoading:Boolean = false
)