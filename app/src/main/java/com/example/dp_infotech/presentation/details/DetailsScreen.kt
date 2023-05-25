package com.example.dp_infotech.presentation.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
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
    val city = LatLng(state.city!!.coord.lat,state.city.coord.lon)
    val cameraPositionState = rememberCameraPositionState{
        position  = CameraPosition.fromLatLngZoom(city,10f)
    }

    Column {
        state.city.name?.let { Text(it) }
        Text("${state.city.coord.lon} and ${state.city.coord.lat}")
        Text("Max temperature:${state.weatherInfo?.main?.temp_max}")
        Text("Min temperature:${state.weatherInfo?.main?.temp_min}")
        Text("Humidity:${state.weatherInfo?.main?.humidity}")
        Text("Wind speed:${state.weatherInfo?.wind?.speed}")
        Text("City Name:${state.weatherInfo?.name}")

        GoogleMap(modifier = Modifier.fillMaxSize(),cameraPositionState = cameraPositionState){
            Marker(state = MarkerState(position = city), title = "Home")
        }

    }


}