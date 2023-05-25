package com.example.dp_infotech.presentation.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dp_infotech.presentation.common.ProgressBar
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun DetailsScreen(
    viewModel: DetailScreenViewModel = hiltViewModel(),

    ) {
    val state = viewModel.state.value
    val city = LatLng(state.city!!.coord.lat, state.city.coord.lon)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(city, 10f)
    }

    if (state.isLoading) {
        ProgressBar()
    } else {
        Column(modifier = Modifier.fillMaxSize()) {
            GoogleMap(
                modifier = Modifier.weight(1f),
                cameraPositionState = cameraPositionState
            ) {
                Marker(state = MarkerState(position = city), title = "Home")
            }
            WeatherDescription(state, modifier = Modifier.weight(2f))

        }
    }
}

@Composable
fun WeatherDescription(state: WeatherDetailState,modifier: Modifier) {
    state.city?.name?.let { Text(it) }
    val description = state.weatherInfo?.weather?.map { weather ->
        weather.description.replace("[\\[\\]]".toRegex(), "")
    }
    val descriptionText = description?.joinToString(", ")
    Box(modifier = modifier.fillMaxSize()) {
        Column {
            Text("${state.city?.coord?.lon} and ${state.city?.coord?.lat}")
            Text("Max temperature:${state.weatherInfo?.main?.temp_max}")
            Text("Min temperature:${state.weatherInfo?.main?.temp_min}")
            Text("Humidity:${state.weatherInfo?.main?.humidity}")
            Text("Wind speed:${state.weatherInfo?.wind?.speed}")
            Text("City Name:${state.weatherInfo?.name}")
            Text("Description :${descriptionText}")
        }
    }
}