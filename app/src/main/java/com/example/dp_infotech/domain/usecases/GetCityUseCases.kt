package com.example.dp_infotech.domain.usecases

import android.util.Log
import com.example.dp_infotech.data.model.City
import com.example.dp_infotech.domain.repository.CityRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class GetCityUseCases @Inject constructor(private val repository: CityRepository) {
     operator fun invoke(id:String):Flow<City>?{
        return repository.getCityById(id)
    }
}