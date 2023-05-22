package com.example.dp_infotech.domain.repository

import com.example.dp_infotech.data.model.City

interface CityRepository {
    suspend fun getCities():List<City>
}