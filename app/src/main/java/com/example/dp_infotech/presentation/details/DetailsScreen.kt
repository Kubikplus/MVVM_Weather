package com.example.dp_infotech.presentation.details

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
@Composable
fun DetailsScreen(navController: NavController, viewModel: DetailScreenViewModel = hiltViewModel(),cityId:Int){
    Text(
        text = "Hello World",
        style = MaterialTheme.typography.body1,
        modifier = Modifier.padding(8.dp),
        color = Color.Black
    )

}