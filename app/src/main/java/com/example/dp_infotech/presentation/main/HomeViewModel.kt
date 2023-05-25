package com.example.dp_infotech.presentation.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dp_infotech.domain.usecases.CitiesUseCases
import com.example.dp_infotech.domain.usecases.GetWeather
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val cityUseCases: CitiesUseCases
) : ViewModel() {

    private val _state = mutableStateOf(WeatherState())
    val state: State<WeatherState> = _state

    init {
        getCountry()

    }

    private fun getCountry() {
        viewModelScope.launch {
            cityUseCases().collect { cities ->
                _state.value = _state.value.copy(cities = cities)
            }
        }
    }

}



//    private fun getCountry( citiesOrder: CitiesOrder) {
//        lateinit var jsonString: String
//        try {
//            jsonString = context.assets.open("city_list.json")
//                .bufferedReader()
//                .use { it.readText() }
//        } catch (ioExceptions: IOException) {
//            Log.e("Country", "Error due get countries")
//
//        }
//        val listCountryType = object : TypeToken<List<Country>>() {}.type
//        return Gson().fromJson(jsonString, listCountryType)
//    }
