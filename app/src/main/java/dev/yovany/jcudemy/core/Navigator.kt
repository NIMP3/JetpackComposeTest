package dev.yovany.jcudemy.core

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import dev.yovany.jcudemy.core.Routes.*
import dev.yovany.jcudemy.data.Item
import dev.yovany.jcudemy.ui.components.CustomButtonView
import dev.yovany.jcudemy.ui.components.CustomDialogView
import dev.yovany.jcudemy.ui.components.CustomImageView
import dev.yovany.jcudemy.ui.components.CustomProgressBarView
import dev.yovany.jcudemy.ui.components.CustomSliderView
import dev.yovany.jcudemy.ui.components.CustomTextAndTextFieldView
import dev.yovany.jcudemy.ui.components.OtherComponentsView
import dev.yovany.jcudemy.ui.components.SelectionControlComponentsView
import dev.yovany.jcudemy.ui.instagram.LoginScreen
import dev.yovany.jcudemy.ui.menu.DataViewModel
import dev.yovany.jcudemy.ui.menu.ItemDetailView
import dev.yovany.jcudemy.ui.menu.MenuView

@Composable
fun ContentWrapper(navigationController: NavHostController) {

    NavHost(navController = navigationController, startDestination = Menu.route) {
        composable(Menu.route) {
            MenuView() { service, name, description ->
                when (service) {
                    "Components" -> navigationController.navigate(ItemDetail.createRoute(name, description))
                    "Instagram UI" -> navigationController.navigate(Login.route)
                }
            }
        }

        composable(ItemDetail.route, arguments = listOf(
            navArgument("name") { type = NavType.StringType },
            navArgument("description") { type = NavType.StringType })
        ) {
            val name = it.arguments?.getString("name") ?: ""
            val description = it.arguments?.getString("description") ?: ""
            ItemDetailView(name, description) {
                navigationController.popBackStack()
            }
        }
        composable(Login.route) { LoginScreen() {
            navigationController.popBackStack()
        } }

    }
}

sealed class Routes(val route: String) {
    object Menu : Routes("menu")
    object ItemDetail : Routes("itemDetail/{name}/{description}") {
        fun createRoute(name: String, description: String) = "itemDetail/$name/$description"
    }
    object Login: Routes("login")
}