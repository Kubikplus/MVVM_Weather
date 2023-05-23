package com.example.dp_infotech.presentation.details

import com.example.dp_infotech.data.model.City

data class WeatherDetailState(
    val isLoading:Boolean = false,
    val city:City? = null,
    val error:String = ""
)
