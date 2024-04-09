package dev.yovany.jcudemy.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.CameraEnhance
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Sailing
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FloatingActionButtonView() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
    ) {

        SmallFloatingActionButton(
            onClick = { },
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(bottom = 8.dp)) {
            Icon(Icons.Filled.Search , "Favorite")
        }

        FloatingActionButton(
            onClick = { },
            contentColor = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 8.dp)) {
            Icon(Icons.Filled.Favorite, "Favorite")
        }

        LargeFloatingActionButton(
            onClick = { },
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(bottom = 8.dp)) {
            Icon(Icons.Filled.Camera, "Favorite", modifier = Modifier.size(48.dp))
        }

        ExtendedFloatingActionButton(onClick = {  },
            containerColor = Color(0xFF8134AF),
            contentColor = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(bottom = 8.dp),
            text = { Text(text = "Instagram") },
            icon = { Icon(Icons.Filled.CameraEnhance, contentDescription = "Share")}
        )

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFloatingActionButtonView() {
    FloatingActionButtonView()
}