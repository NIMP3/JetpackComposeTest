package dev.yovany.jcudemy

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import dev.yovany.jcudemy.core.ContentWrapper
import dev.yovany.jcudemy.ui.theme.JCUdemyTheme

@AndroidEntryPoint
class NavigationActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JCUdemyTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Routes.ScreenOne.route) {
                        composable(Routes.ScreenOne.route) { ScreenOne(navController) }
                        composable(Routes.ScreenTwo.route) { ScreenTwo(navController) }
                        composable(Routes.ScreenThree.route) { ScreenThree(navController) }
                        composable(Routes.ScreenFour.route, arguments = listOf(
                            navArgument("name") { type = NavType.StringType },
                            navArgument("age") { type = NavType.IntType }
                        )) {
                            val name = it.arguments?.getString("name").orEmpty()
                            val age = it.arguments?.getInt("age") ?: 0

                            ScreenFour(navController = navController, name = name, age = age)
                        }
                        composable(Routes.ScreenFive.route, arguments = listOf(
                            navArgument("name") { defaultValue = "Yovany"}
                        )) {
                            val name = it.arguments?.getString("name")
                            ScreenFive(name = name)
                        }
                    }
                }
            }
        }
    }
}

sealed class Routes(val route: String) {
    object ScreenOne: Routes("screenOne")
    object ScreenTwo: Routes("screenTwo")
    object ScreenThree: Routes("screenThree")
    object ScreenFour: Routes("screenFour/{name}/{age}") {
        fun createRoute(name: String, age: Int) = "screenFour/$name/$age"
    }
    object ScreenFive: Routes("screenFive?name={name}") {
        fun createRoute(name: String? = null) = "screenFive${if (!name.isNullOrEmpty()) "?name=$name" else ""}"
    }
}