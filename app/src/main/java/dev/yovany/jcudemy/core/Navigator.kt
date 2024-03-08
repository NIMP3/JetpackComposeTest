package dev.yovany.jcudemy.core

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.yovany.jcudemy.ui.menu.DataViewModel
import dev.yovany.jcudemy.ui.menu.MenuView

@Composable
fun ContentWrapper(navigationController: NavHostController) {

    NavHost(navController = navigationController, startDestination = Routes.Menu.route) {
        composable(Routes.Menu.route) {
            MenuView()
        }
    }
}

sealed class Routes(val route: String) {
    object Menu : Routes("menu")
}