package dev.yovany.jcudemy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import dev.yovany.jcudemy.ui.theme.JCUdemyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JCUdemyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var name by rememberSaveable { mutableStateOf("") }
                    var lastName by rememberSaveable { mutableStateOf("") }
                    MyTextFieldOutlined(
                        name = name,
                        lastName = lastName,
                        onNameChange = { name = it },
                        onLastNameChange = { lastName = it }
                    )
                }
            }
        }
    }
}

