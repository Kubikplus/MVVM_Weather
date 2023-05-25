package com.example.dp_infotech.presentation.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.dp_infotech.data.model.city.City
import com.example.dp_infotech.presentation.utils.Screens

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    // Filtered city list based on search query
    Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
        Column {
            if(state.isLoading) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            else
            SearchBar { viewModel.onSearchQueryChange(it) }
            CityList(navController = navController, state)

        }
    }
}

@Composable
fun CityList(navController: NavController, state: WeatherState) {
    val filteredCities = remember { mutableStateListOf<City>() }
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        itemsIndexed(filteredCities) { index, city ->
            val odd = index % 2 == 0
            CityItem(city = city, odd){
                navController.navigate(Screens.Details.route + "?cityId=${city.id}")
            }
        }
    }
    LaunchedEffect(state.cities, state.searchQuery) {
        filteredCities.clear()
        filteredCities.addAll(state.cities.filter { city ->
            city.name!!.contains(state.searchQuery, ignoreCase = true)
        })
    }

}

// Observe state changes and update filteredCities accordingly


@Composable
fun CityItem(city: City, odd: Boolean,onClick:()->Unit) {
    val imageLink = if (odd) {
        "https://infotech.gov.ua/storage/img/Temp3.png"
    } else {
        "https://infotech.gov.ua/storage/img/Temp1.png"
    }
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable(onClick = onClick)) {
        AsyncImage(model = imageLink, contentDescription = null)

        Text(
            text = city.name!!,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp)
        )
    }

}

@Composable
fun SearchBar(onSearch: (String) -> Unit) {
    var text by remember {
        mutableStateOf("")
    }
    TextField(
        value = text,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = {
            text = it
            onSearch(it)

        },
        singleLine = true,
        maxLines = 1,
        label = { Text("Search", color = Color.Black) }
    )
}

