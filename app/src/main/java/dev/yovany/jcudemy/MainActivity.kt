package dev.yovany.jcudemy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.yovany.jcudemy.core.ContentWrapper
import dev.yovany.jcudemy.tasks.ui.TasksViewModel
import dev.yovany.jcudemy.ui.instagram.ui.LoginViewModel
import dev.yovany.jcudemy.ui.theme.JCUdemyTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val loginViewModel: LoginViewModel by viewModels()
    private val tasksViewModel: TasksViewModel by viewModels()

    private lateinit var navigationController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JCUdemyTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize()
                ) {
                    navigationController = rememberNavController()
                    ContentWrapper(navigationController, loginViewModel, tasksViewModel)
                }
            }
        }
    }
}

