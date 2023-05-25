package com.example.dp_infotech.domain.usecases

import android.util.Log
import com.example.dp_infotech.data.model.city.City
import com.example.dp_infotech.domain.repository.CityRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class CitiesUseCases @Inject constructor(private val repository: CityRepository) {
    operator fun invoke(): Flow<List<City>> = flow {
        try {
            val cities = repository.getCities()
            emit(cities)
        } catch (e: HttpException) {
            Log.e("Error", "This shit happened")
            throw e // rethrow the exception to propagate it further if needed
        }
    }
}