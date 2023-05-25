package com.example.dp_infotech.presentation.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dp_infotech.domain.repository.WeatherRepository
import com.example.dp_infotech.domain.usecases.GetCityUseCases
import com.example.dp_infotech.domain.usecases.GetWeather
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val cityUseCases: GetCityUseCases, private val weather: WeatherRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(WeatherDetailState())
    val state: State<WeatherDetailState> = _state

    init {
        savedStateHandle.get<String>("cityId")?.let { cityId ->
            getCity(cityId)
            getWeather(_state.value.city!!.coord.lat, _state.value.city!!.coord.lon)

        }
    }

    private fun getCity(cityId: String) {
        cityUseCases(cityId)?.onEach {
            _state.value = WeatherDetailState(city = it)
        }?.launchIn(viewModelScope)
    }

    private fun getWeather(lat: Double, lon: Double) {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            try {
                _state.value = _state.value.copy(
                    weatherInfo = weather.getWeatherData(lat, lon), isLoading = false
                )
            } catch (e: Exception) {
                _state.value = _state.value.copy(isLoading = false)
            }


        }
    }


}