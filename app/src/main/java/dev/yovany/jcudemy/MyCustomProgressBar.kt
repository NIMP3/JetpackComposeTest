package dev.yovany.jcudemy

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NavigateBefore
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
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

@Composable
fun MyCustomProgressBar() {
    var showLoading by rememberSaveable { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (showLoading) {
            CircularProgressIndicator(
                color = Color.Blue,
                strokeWidth = 8.dp,
                modifier = Modifier.size(64.dp)
            )
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 16.dp),
                color = Color(0xFF06A888),
                trackColor = Color(0xFF046854),
            )
        }

        Button(onClick = { showLoading = !showLoading }, modifier = Modifier.padding(top = 16.dp)) {
            if (!showLoading) {
                Text(text = "Mostrar")
            } else {
                Text(text = "Ocultar")
            }
        }
    }
}

@Composable
fun MyCustomAdvancedProgressBar() {
    var progress by rememberSaveable { mutableStateOf(0f) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "${(progress * 100).toInt()} %",
            modifier = Modifier.padding(bottom = 16.dp),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF283593)
        )

        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFF283593),
            trackColor = Color(0xFFC8CFFF),
            progress = progress,
        )

        Spacer(modifier = Modifier.padding(top = 16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = { if (progress > 0f) progress -= 0.1f },
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    imageVector = Icons.Default.NavigateBefore,
                    contentDescription = "Decrementar"
                )
            }

            Button(
                onClick = { if (progress < 1f) progress += 0.1f },
                modifier = Modifier.weight(1f)
            ) { Icon(imageVector = Icons.Default.NavigateNext, contentDescription = "Incrementar") }
        }
    }
}

@Composable
fun MyCustomProgressBarScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
    ) {
        MyCustomProgressBar()
        MyCustomAdvancedProgressBar()
    }
}

@Preview(showBackground = true)
@Composable
fun MyCustomProgressBarPreview() {
    MyCustomProgressBarScreen()
}