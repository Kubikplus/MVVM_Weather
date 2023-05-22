package com.example.dp_infotech.presentation.utils

sealed class Screens (val route:String){
    object Home:Screens("city_screen")
    object Details:Screens("details_screen")
}