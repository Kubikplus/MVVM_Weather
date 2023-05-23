package com.example.dp_infotech.presentation.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dp_infotech.data.model.City
import com.example.dp_infotech.domain.usecases.CitiesUseCases
import com.example.dp_infotech.domain.usecases.GetCityUseCases
import com.example.dp_infotech.presentation.main.WeatherState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val cityUseCases: GetCityUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(WeatherDetailState())
    val state: State<WeatherDetailState> = _state

    init {
        savedStateHandle.get<String>("cityId")?.let { cityId ->
            getCity(cityId)

        }
    }

    private fun getCity(cityId: String) {
        cityUseCases(cityId)?.onEach{
            _state.value = WeatherDetailState(city = it)
        }?.launchIn(viewModelScope)


    }


}