package dev.yovany.jcudemy.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomButtonView() {
    var enabled by rememberSaveable { mutableStateOf(true) }
    var enabledOutlineButton by rememberSaveable { mutableStateOf(true) }
    var enabledTextButton by rememberSaveable { mutableStateOf(true) }
    var enabledFilledTonalButton by rememberSaveable { mutableStateOf(true) }
    var enabledElevatedButton by rememberSaveable { mutableStateOf(true) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
    ) {
        Button(
            onClick = { enabled = !enabled },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            )
        ) {
            Text(text = "Click me")
        }

        OutlinedButton(
            onClick = { enabledOutlineButton = !enabledOutlineButton },
            enabled = enabledOutlineButton,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Black,
                disabledContentColor = Color.Gray
            )
        ) {
            Text(text = "Click me")
        }

        TextButton(onClick = { enabledTextButton = !enabledTextButton }, enabled = enabledTextButton) {
            Text(text = "Click me")
        }

        FilledTonalButton(
            onClick = { enabledFilledTonalButton = !enabledFilledTonalButton},
            enabled = enabledFilledTonalButton) {
            Text(text = "Click me")
        }

        ElevatedButton(
            onClick = { enabledElevatedButton = !enabledElevatedButton },
            enabled = enabledElevatedButton) {
            Text(text = "Click me")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultButtonPreview() {
    CustomButtonView()
}