package com.example.dp_infotech.domain.usecases

import com.example.dp_infotech.data.model.City
import com.example.dp_infotech.domain.repository.CityRepository
import kotlinx.coroutines.flow.Flow

class GetCities(private val repository: CityRepository) {
    suspend operator fun invoke(): List<City> {
        return repository.getCities()
    }
}