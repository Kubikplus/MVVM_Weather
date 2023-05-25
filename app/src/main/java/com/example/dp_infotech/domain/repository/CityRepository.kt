package com.example.dp_infotech.domain.repository

import com.example.dp_infotech.data.model.city.City
import kotlinx.coroutines.flow.Flow

interface CityRepository {
    suspend fun getCities(): List<City>

     fun getCityById(id:String):Flow<City>?

}