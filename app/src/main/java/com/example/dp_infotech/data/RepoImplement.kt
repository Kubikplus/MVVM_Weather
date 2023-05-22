package com.example.dp_infotech.data

import android.content.Context
import com.example.dp_infotech.data.model.City
import com.example.dp_infotech.domain.repository.CityRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepoImplement @Inject constructor(private val context: Context) : CityRepository {
    override suspend fun getCities(): List<City> =
        withContext(Dispatchers.IO) {
            val jsonString = context.assets.open("city_list.json")
                .bufferedReader()
                .use {
                    it.readText()
                }
            val listCityType = object : TypeToken<List<City>>() {}.type
            Gson().fromJson(jsonString, listCityType)
        }
}