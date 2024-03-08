package dev.yovany.jcudemy.ui.menu

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.yovany.jcudemy.MessageView
import dev.yovany.jcudemy.data.Menu
import dev.yovany.jcudemy.R
import dev.yovany.jcudemy.data.Service
import dev.yovany.jcudemy.Utility
import dev.yovany.jcudemy.data.Message
import dev.yovany.jcudemy.data.MessageType
import dev.yovany.jcudemy.data.Resource


@Composable
fun MenuView(dataViewModel: DataViewModel = hiltViewModel()) {
    var showItemsView by remember { mutableStateOf(false) }
    val menu by dataViewModel.menu.collectAsState()
    var data by remember { mutableStateOf(Menu()) }
    var service by remember { mutableStateOf(Service()) }

    LaunchedEffect(Unit) { dataViewModel.getMenu() }

    Column(Modifier.fillMaxSize()) {
        Header(title = data.title, subtitle = data.subtitle, modifier = Modifier.weight(3f))
        when (menu) {
            is Resource.Loading -> {
                MessageView(
                    message = Message(
                        "LOADING",
                        "Obtaining menu data, please wait...",
                        MessageType.LOADING
                    ),
                    modifier = Modifier.weight(7f)
                )
            }

            is Resource.Error -> {
                MessageView(
                    message = Message(
                        "ERROR",
                        "Error obtaining menu data: ${(menu as Resource.Error).message}",
                        MessageType.ERROR
                    ),
                    modifier = Modifier.weight(7f)
                )
            }

            is Resource.Success -> {
                data = (menu as Resource.Success).data!!
                Menu(menu = data, modifier = Modifier.weight(7f)) {
                    service = it
                    showItemsView = true
                }
            }

            else -> {}
        }
    }

    if (showItemsView) {
        ItemsView(
            service = service,
            onDismiss = { showItemsView = false },
            onItemClicked = { item -> Log.d("MenuView", "Item clicked: ${item.name}") }
        )
    }


}

@Composable
fun Header(title: String, subtitle: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color(0xFF6200EE))
            .padding(16.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        Column {
            Text(
                text = title,
                color = Color.White,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = subtitle,
                color = Color.White,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Light
            )
        }
    }
}

@Composable
fun Menu(menu: Menu, modifier: Modifier = Modifier, onServiceClicked: (Service) -> Unit = {}) {
    LazyVerticalGrid(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(16.dp),
        columns = GridCells.Fixed(2)
    ) {
        items(menu.services) { service ->
            ServiceView(service = service, onServiceClicked = onServiceClicked)
        }
    }
}

@Composable
fun ServiceView(service: Service, onServiceClicked: (Service) -> Unit = {}) {
    val color: Color = Utility.getColorFromString(service.color)?.let { Color(it) } ?: Color.Black
    val resource: Int = Utility.getResourceId(LocalContext.current, service.resource, "drawable")
        ?: R.drawable.ic_default_service

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable { onServiceClicked(service) },
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(
            contentColor = Color(0xFFFFFFFF),
            containerColor = Color.White
        )
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(96.dp)
                    .padding(16.dp)
                    .clip(CircleShape)
                    .background(color = color),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = resource),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(48.dp)
                )
            }

            Text(
                text = service.service,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black
            )
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MenuViewPreview() {
    MenuView()
}