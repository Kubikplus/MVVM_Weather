package com.example.dp_infotech.presentation.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.dp_infotech.data.model.City
import com.example.dp_infotech.presentation.utils.Screens
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Column {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(state.cities) { country ->
                TwoCellRow(
                    country = country.name ?: "",
                    modifier = Modifier.clickable {
                        navController.navigate(Screens.Details.route + "?cityId=${country.id}")
                    }
                )
            }


        }

    }


}

@Composable
fun TwoCellRow(country: String, modifier: Modifier = Modifier) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Box(modifier = modifier) {

            Text(
                text = country,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}