package dev.yovany.jcudemy.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yovany.jcudemy.R

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "My image",
        alpha = 0.5f,
        modifier = Modifier.background(Color(0xFF18B3AE))
    )
}

@Composable
fun MyImageAdvanced() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "My image",
        alpha = 0.5f,
        modifier = Modifier
            .clip(CircleShape)
            .size(128.dp)
            .border(2.dp, Color.White, CircleShape)
            .background(Color(0xFF18B3AE))
    )
}

@Composable
fun MyIcon() {
    Icon(
        imageVector = Icons.Default.FavoriteBorder,
        contentDescription = "My icon",
        tint = Color.Red,
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .size(48.dp)
            .background(Color(0xFFFFECEB))
    )
}

@Composable
fun CustomImageView() {
    Column(
        Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
    ) {
        MyImage()
        MyImageAdvanced()
        MyIcon()
    }
}

@Preview(showBackground = true)
@Composable
fun MyCustomImagePreview() {
    CustomImageView()
}