package com.example.dp_infotech.presentation.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dp_infotech.data.model.city.City
import com.example.dp_infotech.domain.usecases.CitiesUseCases
import com.example.dp_infotech.domain.usecases.GetWeather
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val cityUseCases: CitiesUseCases
) : ViewModel() {

    private val _state = mutableStateOf(WeatherState())
    val state: State<WeatherState> = _state
    private var cachedPokemonList = listOf<City>()
    private var isSearchStart = true
    var isSearching = mutableStateOf(false)

    init {
        getCountry()

    }


    fun searchPokemonList(query: String) {
        val listToSearch = if (isSearchStart) {
            state.value.cities
        } else {
            cachedPokemonList
        }
        viewModelScope.launch(Dispatchers.Default) {
            if (query.isEmpty()) {
                state.value.cities = cachedPokemonList
                isSearching.value = false
                isSearchStart = true
                return@launch
            }
            val results = state.value.cities.filter {
                it.name!!.contains(query.trim(), ignoreCase = true)
            }
            if (isSearchStart) {
                cachedPokemonList = state.value.cities
                isSearchStart = false
            }
            state.value.cities = results
            isSearching.value = true

        }

    }

    fun onSearchQueryChange(query: String) {
        viewModelScope.launch(Dispatchers.Default) {
            if (query.isEmpty()) {
                return@launch
            } else {
                val currentState = _state.value
                val newState = currentState.copy(searchQuery = query)
                _state.value = newState
            }
        }
    }

    private fun getCountry() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            try {
                val cities = cityUseCases.invoke()
                _state.value = _state.value.copy(cities = cities, isLoading = false)
            } catch (e: Exception) {
                // Handle any error that occurred during fetching
                _state.value = _state.value.copy(isLoading = false)
            }
        }
    }

}
