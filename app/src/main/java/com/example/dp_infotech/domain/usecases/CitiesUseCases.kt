package com.example.dp_infotech.domain.usecases

import android.util.Log
import com.example.dp_infotech.data.model.city.City
import com.example.dp_infotech.domain.repository.CityRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class CitiesUseCases @Inject constructor(private val repository: CityRepository) {
    suspend operator fun invoke(): List<City> {
        return try {
            repository.getCities().toList()
        } catch (e: HttpException) {
            Log.e("Error", "An error occurred while fetching cities", e)
            throw e // Rethrow the exception to propagate it further if needed
        } catch (e: Exception) {
            Log.e("Error", "An unexpected error occurred while fetching cities", e)
            throw e // Rethrow the exception to propagate it further if needed
        }
    }
}
