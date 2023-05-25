package com.example.dp_infotech.domain.usecases

import com.example.dp_infotech.data.model.city.City
import com.example.dp_infotech.domain.repository.CityRepository
import kotlinx.coroutines.flow.Flow

class GetCitiesByID(private val repository: CityRepository) {
     operator fun invoke(id:String): Flow<City>?{
        return repository.getCityById(id)
    }
}