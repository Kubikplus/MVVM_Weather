package com.example.dp_infotech.presentation.main

import com.example.dp_infotech.data.model.city.City

data class WeatherState(
    val cities:List<City> = emptyList(),
    val filteredCities: List<City> = emptyList(),
    val searchQuery: String = "Kyiv",
    var isLoading:Boolean = false
)