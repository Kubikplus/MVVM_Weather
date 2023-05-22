package com.example.dp_infotech

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dp_infotech.presentation.main.HomeScreen
import com.example.dp_infotech.presentation.utils.Screens
import com.example.dp_infotech.ui.theme.DP_InfotechTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DP_InfotechTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController( )
                    NavHost(navController = navController, startDestination = Screens.Home.route ){
                        composable(route = Screens.Home.route){
                            HomeScreen(navController=navController)
                        }
                        composable(
                            route = Screens.Details.route
//                            arguments = listOf(
//                                navArgument("cityId") { type = NavType.IntType }
//                            )
                        ) {
//                            val arguments = requireNotNull(backStackEntry.arguments)
//                            val cityId = arguments.getInt("cityId")
//                            DetailsScreen(navController = navController, cityId = cityId)
                        }

                    }

                }

            }
        }
    }
}



@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DP_InfotechTheme {
        Greeting("Android")
    }
}