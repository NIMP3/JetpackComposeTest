package dev.yovany.jcudemy

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dev.yovany.jcudemy.Routes.ScreenFour
import dev.yovany.jcudemy.Routes.ScreenOne
import dev.yovany.jcudemy.Routes.ScreenThree
import dev.yovany.jcudemy.Routes.ScreenTwo

@Composable
fun ScreenOne(navController: NavHostController) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color(0xFF80CBC4)), contentAlignment = Alignment.Center
    ) {
        Text(text = "Screen One",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color(0xFF004D40),
            modifier = Modifier.clickable { navController.navigate(ScreenTwo.route) })
    }
}

@Composable
fun ScreenTwo(navController: NavHostController) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color(0xFFEF9A9A)), contentAlignment = Alignment.Center
    ) {
        Text(text = "Screen Two",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color(0xFFB71C1C),
            modifier = Modifier.clickable { navController.navigate(ScreenThree.route) })
    }
}

@Composable
fun ScreenThree(navController: NavHostController) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color(0xFF90CAF9)), contentAlignment = Alignment.Center
    ) {
        Text(text = "Screen Three",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color(0xFF0D47A1),
            modifier = Modifier.clickable {
                navController.navigate(ScreenFour.createRoute("Edwin",31))
            })
    }
}

@Composable
fun ScreenFour(navController: NavHostController, name: String, age: Int) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color(0xFFFFAB91)), contentAlignment = Alignment.Center
    ) {
        Text(text = "Screen Four\nHi, $name\nAre you $age years old?",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            color = Color(0xFFBF360C),
            modifier = Modifier.clickable {
                navController.navigate(Routes.ScreenFive.createRoute())
            }
        )
    }
}

@Composable
fun ScreenFive(name: String?) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF59D)), contentAlignment = Alignment.Center
    ) {
        Text(text = "Screen Five\nHi, $name\n How are you?",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            color = Color(0xFFF57F17),
            modifier = Modifier.clickable { ScreenOne.route })
    }
}


@Preview(showBackground = true)
@Composable
fun NavigationViewPreview() {
    val navController = rememberNavController()
    ScreenOne(navController = navController)
}