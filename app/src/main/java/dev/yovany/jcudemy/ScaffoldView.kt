package dev.yovany.jcudemy

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldView() {
    val snackBarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = { MyTopAppBar() {action ->
            val message = when (action) {
                "BACK" -> "Can't go back"
                "SEARCH" -> "Searching..."
                "SETTINGS" -> "Don't access settings"
                else -> "Unknown action"
            }

            coroutineScope.launch {
                snackBarHostState.showSnackbar(message)
            }
        } },
        bottomBar = { MyNavigationBar() },
        snackbarHost = { SnackbarHost(snackBarHostState) }) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // ConstraintExample()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit) {
    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(onClick = { onClickIcon("BACK") }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back")
            }
        },
        title = {
            Column {
                Text("Jetpack Compose", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                Text(
                    "Project to learn Jetpack Compose",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("SEARCH") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "search")
            }
            IconButton(onClick = { onClickIcon("SETTINGS") }) {
                Icon(imageVector = Icons.Filled.Settings, contentDescription = "settings")
            }
        },
        modifier = Modifier.shadow(
            elevation = 5.dp,
            spotColor = Color.DarkGray
        )
    )
}

@Composable
fun MyNavigationBar() {
    var selected by remember { mutableStateOf(0) }
    val colors = NavigationBarItemDefaults.colors(
        selectedIconColor = Color.White,
        unselectedIconColor = MaterialTheme.colorScheme.tertiary,
        indicatorColor = MaterialTheme.colorScheme.primary,
        selectedTextColor = MaterialTheme.colorScheme.secondary,
        unselectedTextColor = MaterialTheme.colorScheme.tertiary
    )
    
    NavigationBar {
        NavigationBarItem(selected = selected == 0, onClick = { selected = 0 }, icon = {
            Icon(imageVector = Icons.Filled.Person, contentDescription = "user")
        }, label = { Text("User") }, colors = colors)
        NavigationBarItem(selected = selected == 1, onClick = { selected = 1 }, icon = {
            Icon(imageVector = Icons.Filled.Home, contentDescription = "home")
        }, label = { Text("Home") }, colors = colors)
        NavigationBarItem(selected = selected == 2, onClick = { selected = 2 }, icon = {
            Icon(imageVector = Icons.Filled.Favorite, contentDescription = "favorite")
        }, label = { Text("Favorite") }, colors = colors)
    }
}


@Preview(showBackground = true)
@Composable
fun ScaffoldViewPreview() {
    ScaffoldView()
}