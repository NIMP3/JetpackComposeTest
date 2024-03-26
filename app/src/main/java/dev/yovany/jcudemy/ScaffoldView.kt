package dev.yovany.jcudemy

import android.graphics.drawable.DrawableContainer.DrawableContainerState
import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
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
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(drawerState = drawerState, drawerContent = { MyDrawer() {option ->
        coroutineScope.launch {
            drawerState.close()
            snackBarHostState.showSnackbar("Selected $option")
        }
    } }) {
        Scaffold(
            topBar = {
                MyTopAppBar() { action ->
                    if (action == "MENU") {
                        coroutineScope.launch {
                            drawerState.apply {
                                if (drawerState.isOpen) close() else open()
                            }
                        }
                    } else {
                        val message = when (action) {
                            "SEARCH" -> "Searching..."
                            "SETTINGS" -> "Don't access settings"
                            else -> "Unknown action"
                        }

                        coroutineScope.launch {
                            snackBarHostState.showSnackbar(message)
                        }
                    }
                }
            },
            bottomBar = { MyNavigationBar() },
            floatingActionButton = { MyFloatingButton() },
            floatingActionButtonPosition = FabPosition.End,
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
            IconButton(onClick = { onClickIcon("MENU") }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "menu")
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

@Composable
fun MyFloatingButton() {
    FloatingActionButton(onClick = { }, containerColor = MaterialTheme.colorScheme.secondary) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
    }
}

@Composable
fun MyDrawer(onClick: (String) -> Unit) {
    val options = listOf(
        "Profile" to Icons.Filled.Person,
        "Home" to Icons.Filled.Home,
        "Favorite" to Icons.Filled.Favorite
    )

    Column(
        Modifier
            .fillMaxSize()
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(3f)
                .background(MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.BottomStart
        ) {
            Column {
                Text(
                    text = "Jetpack Compose",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Text(
                    text = "Project to learn Jetpack Compose",
                    color = Color.White,
                    modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
                )
            }
        }


        LazyColumn(Modifier.weight(7f)) {
            items(options) { (title, icon) ->
                MyDrawerItem(title, icon, onClick)
            }
        }
    }
}

@Composable
fun MyDrawerItem(title: String, resource: ImageVector, onClick: (String) -> Unit) {
    Column {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable { onClick(title) }
        ) {
            Icon(imageVector = resource, contentDescription = title)
            Text(
                text = title,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Divider(thickness = 1.dp, color = Color.Gray)
    }
}


@Preview(showBackground = true)
@Composable
fun ScaffoldViewPreview() {
    ScaffoldView()
}