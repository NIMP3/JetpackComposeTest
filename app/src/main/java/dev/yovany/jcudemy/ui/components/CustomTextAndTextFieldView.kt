package dev.yovany.jcudemy.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyText(text: String) {
    Column(Modifier.fillMaxWidth()) {
        Text(text = text)
        Text(text = text, color = Color.Blue)
        Text(text = text, fontWeight = FontWeight.ExtraBold)
        Text(text = text, fontWeight = FontWeight.Light)
        Text(text = text, style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(text = text, fontFamily = FontFamily.Serif)
        Text(text = text, style = TextStyle(textDecoration = TextDecoration.LineThrough))
        Text(text = text, style = TextStyle(textDecoration = TextDecoration.Underline))
        Text(
            text = text, style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(
                        TextDecoration.LineThrough, TextDecoration.Underline
                    )
                )
            )
        )
        Text(text = text, fontSize = 24.sp)

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField() {
    var myText by rememberSaveable { mutableStateOf("") }
    TextField(value = myText, onValueChange = { myText = it }, modifier = Modifier.fillMaxWidth())
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldAdvanced() {
    var myText by rememberSaveable { mutableStateOf("") }

    TextField(
        value = myText,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = { myText = if (it.contains("a")) it.replace("a", "") else it },
        label = { Text(text = "Ingrea tu nombre") })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldOutlined(
    name: String,
    lastName: String,
    onNameChange: (String) -> Unit,
    onLastNameChange: (String) -> Unit
) {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text(text = "Ingrea tu nombre") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Magenta,
                unfocusedBorderColor = Color.Black
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        )
        OutlinedTextField(
            value = lastName, onValueChange = onLastNameChange,
            label = { Text(text = "Ingrea tu apellido") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Red,
                unfocusedBorderColor = Color.Gray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}

@Composable
fun MyHorizontalDivider() {
    Divider(
        thickness = 1.dp,
        color = Color.Gray,
        modifier = Modifier.padding(vertical = 24.dp)
    )
}

@Composable
fun CustomTextAndTextFieldView() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        MyText(text = "Hello Edwin")
        MyHorizontalDivider()
        MyTextField()
        MyHorizontalDivider()
        MyTextFieldAdvanced()
        MyHorizontalDivider()
        MyTextFieldOutlined(name = "", lastName = "", onNameChange = {}, onLastNameChange = {})
    }
}

@Preview(showBackground = true)
@Composable
fun CustomTextAndTextFieldViewPreview() {
    CustomTextAndTextFieldView()
}