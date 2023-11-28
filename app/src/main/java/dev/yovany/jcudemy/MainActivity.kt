package dev.yovany.jcudemy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    MyBox(name = "Edwin")
                }
            }
        }
    }
}

@Composable
fun MyBox(name: String, modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(150.dp)
                .background(Color.Magenta)
        )
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .background(Color.Blue)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Hello $name. How are you?\nWhere are you from?\nWhat do you do?",
                color = Color.White
            )
        }
    }
}

@Composable
fun MyColumn() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            "Hello Edwin", modifier = Modifier
                .background(Color.Red)
                .weight(1f)
                .fillMaxWidth()
        )
        Text(
            "Hello Yovany", modifier = Modifier
                .background(Color.Green)
                .weight(3f)
                .fillMaxWidth()
        )
        Text(
            "Hello Yesica", modifier = Modifier
                .background(Color.Blue)
                .weight(1f)
                .fillMaxWidth()
        )
        Text(
            "Hello Jenny", modifier = Modifier
                .background(Color.Yellow)
                .weight(3f)
                .fillMaxWidth()
        )
        Text(
            "Hello Jhon", modifier = Modifier
                .background(Color.Magenta)
                .weight(1f)
                .fillMaxWidth()
        )
    }
}

@Composable
fun MyColumn2() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            "Hello Edwin", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Hello Yovany", modifier = Modifier
                .background(Color.Green)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Hello Yesica", modifier = Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Hello Jenny", modifier = Modifier
                .background(Color.Yellow)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Hello Jhon", modifier = Modifier
                .background(Color.Magenta)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Hello Martin", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Hello Lizeth", modifier = Modifier
                .background(Color.Gray)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Hello Jhonatan", modifier = Modifier
                .background(Color.DarkGray)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Hello Juan", modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Hello Jeison", modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Hello Pablo", modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Hello Miguel", modifier = Modifier
                .background(Color.DarkGray)
                .fillMaxWidth()
                .height(100.dp)
        )
    }
}

@Composable
fun MyRow() {
    Row {
        Text(
            "Hello Edwin", modifier = Modifier
                .background(Color.Red)
                .weight(1f)
                .height(100.dp)
                .weight(1f)
        )
        Text(
            "Hello Yovany", modifier = Modifier
                .background(Color.Green)
                .weight(1f)
                .height(100.dp)
                .weight(1f)
        )
        Text(
            "Hello Yesica", modifier = Modifier
                .background(Color.Blue)
                .weight(1f)
                .height(100.dp)
                .weight(1f)
        )
        Text(
            "Hello Jenny", modifier = Modifier
                .background(Color.Yellow)
                .weight(1f)
                .height(100.dp)
                .weight(1f)
        )
    }
}

@Composable
fun MyRow2() {
    Row(modifier = Modifier
        .fillMaxSize()
        .horizontalScroll(rememberScrollState())) {
        Text(
            "1",
            textAlign = TextAlign.Center, color = Color.White,
            modifier = Modifier
                .background(Color.Red)
                .height(100.dp)
                .width(100.dp)
                .wrapContentHeight(align = Alignment.CenterVertically)
        )
        Text(
            "2",
            textAlign = TextAlign.Center, color = Color.White,
            modifier = Modifier
                .background(Color.Green)
                .height(100.dp)
                .width(100.dp)
                .wrapContentHeight(align = Alignment.CenterVertically)
        )
        Text(
            "3",
            textAlign = TextAlign.Center, color = Color.White,
            modifier = Modifier
                .background(Color.Blue)
                .height(100.dp)
                .width(100.dp)
                .wrapContentHeight(align = Alignment.CenterVertically)
        )
        Text(
            "4",
            textAlign = TextAlign.Center, color = Color.White,
            modifier = Modifier
                .background(Color.Yellow)
                .height(100.dp)
                .width(100.dp)
                .wrapContentHeight(align = Alignment.CenterVertically)
        )
        Text(
            "5",
            textAlign = TextAlign.Center, color = Color.White,
            modifier = Modifier
                .background(Color.Magenta)
                .height(100.dp)
                .width(100.dp)
                .wrapContentHeight(align = Alignment.CenterVertically)
        )
        Text(
            "6",
            textAlign = TextAlign.Center, color = Color.White,
            modifier = Modifier
                .background(Color.Cyan)
                .height(100.dp)
                .width(100.dp)
                .wrapContentHeight(align = Alignment.CenterVertically)
        )
        Text("7",
            textAlign = TextAlign.Center, color = Color.White,
            modifier = Modifier
                .background(Color.Gray)
                .height(100.dp)
                .width(100.dp)
                .wrapContentHeight(align = Alignment.CenterVertically)
        )
        Text(
            "8",
            textAlign = TextAlign.Center, color = Color.White,
            modifier = Modifier
                .background(Color.DarkGray)
                .height(100.dp)
                .width(100.dp)
                .wrapContentHeight(align = Alignment.CenterVertically)
        )
    }
}

@Composable
fun MyComplexLayout() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .background(Color.Cyan), contentAlignment = Alignment.Center) {

            Text("Ejemplo 1", fontSize = 24.sp)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)) {
            Box(modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(Color.Red), contentAlignment = Alignment.Center) {
                Text("Ejemplo 2", color = Color.White, fontSize = 24.sp)
            }
            Box(modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(Color.Green)) {
                Text(
                    "Ejemplo 3",
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .wrapContentHeight(align = Alignment.CenterVertically),
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.Underline,
                    fontSize = 24.sp
                )
            }
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .background(Color.Magenta), contentAlignment = Alignment.BottomCenter) {
            Text("Ejemplo 4", color = Color.White, fontSize = 24.sp)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    JCUdemyTheme {
        MyComplexLayout()
    }
}