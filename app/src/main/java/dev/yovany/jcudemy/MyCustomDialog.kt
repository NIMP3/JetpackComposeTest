package dev.yovany.jcudemy

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import java.util.Locale

@Composable
fun MyDialog(show: Boolean = true, onDismissRequest: () -> Unit = {}) {
    if (!show) return
    AlertDialog(
        onDismissRequest = {},
        confirmButton = {
            TextButton(onClick = { onDismissRequest() }) {
                Text(text = "Aceptar")
            }
        },
        dismissButton = {
            TextButton(onClick = { onDismissRequest() }) {
                Text(text = "Cancelar")
            }
        },
        title = { Text(text = "Alerta") },
        text = { Text(text = "Se presento un error en la aplicacion, por favor intente mas tarde.") },
    )
}

@Composable
fun MySimpleCustomDialog(show: Boolean = true, onDismissRequest: () -> Unit = {}) {
    if (!show) return
    Dialog(
        onDismissRequest = { onDismissRequest() },
        properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
    ) {
        Card(
            shape = MaterialTheme.shapes.medium,
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
            colors = CardDefaults.cardColors(
                contentColor = Color(0xFF000000),
                containerColor = Color(0xFFFFFFFF)
            ),
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(16.dp)
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Hola mundo")
                Spacer(modifier = Modifier.height(4.dp))
                TextButton(onClick = { onDismissRequest() }) {
                    Text(text = "Aceptar")
                }
            }
        }
    }
}

@Composable
fun MyCustomDialog(show: Boolean, onDismissRequest: () -> Unit) {
    if (!show) return
    Dialog(
        onDismissRequest = { onDismissRequest() },
        properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = true)
    ) {
        Card(
            shape = MaterialTheme.shapes.small,
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
            colors = CardDefaults.cardColors(
                contentColor = Color(0xFF000000),
                containerColor = Color(0xFFFFFFFF)
            ),
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                    .background(Color.White)
            ) {
                MyTitleDialog(title = "Set backup account")
                AccountItem(email = "ejemplo1@test.com", drawable = R.drawable.img_user_one)
                AccountItem(email = "ejemplo3@test.com", drawable = R.drawable.img_user_three)
                AccountItem(email = "Add account", drawable = R.drawable.ic_add)
            }
        }
    }
}

@Composable
fun MyConfirmationDialog(show: Boolean, onDismissRequest: () -> Unit) {
    if (!show) return

    var status by rememberSaveable { mutableStateOf("") }

    Dialog(
        onDismissRequest = { onDismissRequest() },
        properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = true)
    ) {
        Card(
            shape = MaterialTheme.shapes.small,
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
            colors = CardDefaults.cardColors(
                contentColor = Color(0xFF000000),
                containerColor = Color(0xFFFFFFFF)
            ),
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                MyTitleDialog(title = "Phone ringtone", modifier = Modifier.padding(24.dp))
                Divider(Modifier.fillMaxWidth(), color = Color.LightGray, thickness = 1.dp)
                Ringtones(name = status) { status = it }
                Divider(Modifier.fillMaxWidth(), color = Color.LightGray, thickness = 1.dp)
                Row {
                    MyButton(
                        modifier = Modifier
                            .padding(16.dp)
                            .weight(1f),
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = Color.DarkGray,
                            containerColor = Color(0xFFE0E0E0)
                        ),
                        text = "Cancel"
                    ) { onDismissRequest() }
                    MyButton(
                        modifier = Modifier
                            .padding(16.dp)
                            .weight(1f),
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = Color.White,
                            containerColor = Color(0xFF3F3F3F)
                        ),
                        text = "Apply"
                    ) { onDismissRequest() }
                }
            }
        }
    }
}

@Composable
fun Ringtones(name: String, onItemSelected: (String) -> Unit) {
    Column(Modifier.padding(16.dp)) {
        MyRadioButton(
            name == "None",
            "None",
            onClick = { onItemSelected("") })
        MyRadioButton(
            name == "Callisto",
            "Callisto",
            onClick = { onItemSelected("Callisto") })
        MyRadioButton(
            name == "Ganymede",
            "Ganymede",
            onClick = { onItemSelected("Ganymede") })
        MyRadioButton(
            name == "Luna",
            "Luna",
            onClick = { onItemSelected("Luna") })
        MyRadioButton(
            name == "Titan",
            "Titan",
            onClick = { onItemSelected("Titan") })
        MyRadioButton(
            name == "Venus",
            "Venus",
            onClick = { onItemSelected("Venus") })
        MyRadioButton(
            name == "Zephyr",
            "Zephyr",
            onClick = { onItemSelected("Zephyr") })
    }
}

@Composable
fun MyTitleDialog(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
    )
}

@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(end = 16.dp)
                .size(48.dp)
                .clip(CircleShape)
                .background(Color.Gray)
        )

        Text(
            text = email,
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun MyButton(
    modifier: Modifier,
    colors: ButtonColors,
    text: String,
    onClick: () -> Unit
) {
    TextButton(
        onClick = onClick,
        colors = colors,
        modifier = modifier,
        shape = MaterialTheme.shapes.small
    ) {
        Text(
            text = text.capitalize(locale = Locale.getDefault()),
            Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
        )
    }
}

@Composable
fun MyBox() {
    var show by remember { mutableStateOf(false) }
    var showSimpleCustomDialog by remember { mutableStateOf(false) }
    var showAccountDialog by remember { mutableStateOf(false) }
    var showConfirmation by remember { mutableStateOf(false) }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        MyDialog(show) { show = false }
        MySimpleCustomDialog(showSimpleCustomDialog) { showSimpleCustomDialog = false }
        MyCustomDialog(showAccountDialog) { showAccountDialog = false }
        MyConfirmationDialog(showConfirmation) { showConfirmation = false }

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            MyButton(
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Color.White,
                    containerColor = Color(0xFF3F51B5)
                ),
                text = "Abrir",
            ) { show = !show }

            MyButton(
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Color.White,
                    containerColor = Color(0xFF009688)
                ),
                text = "Abrir"
            ) { showSimpleCustomDialog = !showSimpleCustomDialog }
        }
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            MyButton(
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Color.White,
                    containerColor = Color(0xFFE91E63)
                ),
                text = "Google"
            ) { showAccountDialog = !showAccountDialog }

            MyButton(
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Color.White,
                    containerColor = Color(0xFF673AB7)
                ),
                text = "Ringtone"
            ) { showConfirmation = !showConfirmation }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyDialogPreview() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MyBox()
    }
}