package dev.yovany.jcudemy.ui.animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.UploadFile
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.yovany.jcudemy.ui.animations.ComponentType.*
import kotlin.random.Random.Default.nextInt

@Composable
fun BasicAnimationsView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BoxWithoutColorAnimation(Color.Blue, Color.Red)
        Spacer(modifier = Modifier.height(12.dp))
        BoxWithColorAnimation(Color.Cyan, Color.Magenta)
        Spacer(modifier = Modifier.height(12.dp))
        BoxWithSizeAnimation()
        Spacer(modifier = Modifier.height(12.dp))
        BoxWithVisibilityAnimation()
        Spacer(modifier = Modifier.height(12.dp))
        CrossFadeAnimation()
    }
}

@Composable
fun CrossFadeAnimation() {
    var type by rememberSaveable { mutableStateOf(Favorite) }

    Column {
        Box(
            modifier = Modifier
                .size(200.dp)
                .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(10))
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Crossfade(targetState = type, animationSpec = tween(1000), label = "CrossFade") {
                when(it) {
                    Favorite -> Icon(Icons.Filled.Favorite, contentDescription = "Favorite", modifier = Modifier.size(124.dp), tint = Color.Red)
                    Share -> Icon(Icons.Filled.Share, contentDescription = "Share", modifier = Modifier.size(124.dp), tint = Color.Blue)
                    Upload -> Icon(Icons.Filled.UploadFile, contentDescription = "Upload", modifier = Modifier.size(124.dp), tint = Color.Green)
                    Download -> Icon(Icons.Filled.Download, contentDescription = "Download", modifier = Modifier.size(124.dp), tint = Color.Cyan)
                    Error -> Icon(Icons.Filled.Error, contentDescription = "Error", modifier = Modifier.size(124.dp), tint = Color.Yellow)
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { type = getComponentTypeRandom() },
            shape = RoundedCornerShape(20),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF51C7)
            ),
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "CHANGE", fontSize = 14.sp, fontWeight = FontWeight.Bold)
        }

    }
}

@Composable
fun BoxWithVisibilityAnimation() {
    var isVisible by rememberSaveable { mutableStateOf(false) }

    AnimatedVisibility(
        isVisible,
        enter = expandIn(animationSpec = tween(500)),
        exit = shrinkOut(animationSpec = tween(500))
    ) {
        Box(modifier = Modifier
            .size(200.dp)
            .background(Color.LightGray)
            .clickable {
            }
        ) {
            IconButton(
                onClick = { isVisible = !isVisible },
                modifier = Modifier.align(Alignment.TopEnd)
            ) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Favorite",
                    tint = Color.DarkGray
                )
            }

            Text(text = "Hello Yovany", modifier = Modifier.align(Alignment.Center))
        }
    }

    AnimatedVisibility(
        !isVisible,
        enter = fadeIn(animationSpec = tween(1000)),
        exit = fadeOut(animationSpec = tween(100))
    ) {
        Button(
            onClick = { isVisible = !isVisible },
            shape = RoundedCornerShape(20),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF3F51B5)
            )
        ) {
            Text(text = "SHOW", fontSize = 14.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun BoxWithSizeAnimation() {
    var smallSize by rememberSaveable { mutableStateOf(true) }
    var showText by rememberSaveable { mutableStateOf(false) }

    val size by animateDpAsState(
        targetValue = if (smallSize) 50.dp else 100.dp,
        animationSpec = tween(durationMillis = 500),
        finishedListener = { showText = !smallSize }
    )

    Box(
        modifier = Modifier
            .size(size)
            .background(Color.Green)
            .clickable {
                smallSize = !smallSize
                if (smallSize) showText = !smallSize
            }, contentAlignment = Alignment.Center
    ) {
        if (showText) Text(text = "Hello Edwin")
    }
}

@Composable
fun BoxWithColorAnimation(
    primaryColor: Color,
    secondaryColor: Color
) {
    var firstColor by rememberSaveable { mutableStateOf(false) }
    var showBox by rememberSaveable { mutableStateOf(true) }

    val color by animateColorAsState(
        targetValue = if (firstColor) primaryColor else secondaryColor,
        animationSpec = tween(durationMillis = 2000),
        finishedListener = { showBox = false }
    )

    if (showBox) {
        Box(modifier = Modifier
            .size(100.dp)
            .background(color)
            .clickable { firstColor = !firstColor })
    }
}

@Composable
fun BoxWithoutColorAnimation(primaryColor: Color, secondaryColor: Color) {
    var firstColor by rememberSaveable { mutableStateOf(false) }
    val color = if (firstColor) primaryColor else secondaryColor

    Box(modifier = Modifier
        .size(100.dp)
        .background(color)
        .clickable { firstColor = !firstColor })
}

enum class ComponentType() {
    Favorite, Share, Upload, Download, Error
}

private fun getComponentTypeRandom(): ComponentType {
    return when (nextInt(from = 0, until = 3)) {
        0 -> Favorite
        1 -> Share
        2 -> Upload
        3 -> Download
        else -> Error
    }
}

@Composable
@Preview(showBackground = true)
fun AnimationViewPreview() {
    BasicAnimationsView()
}