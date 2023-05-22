package com.example.dp_infotech.presentation.main

import com.example.dp_infotech.domain.util.CitiesOrder

sealed class WeatherEvent {
    data class Order(val citiesOrder: CitiesOrder):WeatherEvent()
}