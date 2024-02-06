package dev.yovany.jcudemy

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(
            contentColor = Color(0xFFFFFFFF),
            containerColor = Color(0xFF3F51B5)
        ),
        border = BorderStroke(2.dp, Color(0xFF7A89F1))
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Icon(
                modifier = Modifier
                    .padding(16.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFFFFFFF))
                    .size(64.dp),
                contentDescription = "Image",
                tint = Color(0xFF3F51B5),
                imageVector = Icons.Default.Person,
            )

            Column {
                Text(
                    text = "Edwin Yovany",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFFFFFFF)
                )

                Text(
                    text = "Android Developer",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFFCACACA)
                )

                Text(
                    text = "I'm an Android Developer with 5 years of experience",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFFBDBDBD)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBadgeBox() {
    BadgedBox(badge = {
        Text(text = "1")
    }, Modifier.padding(16.dp)) {
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "Favorite",
            tint = Color(0xFFC62828)
        )
    }
}

@Composable
fun MyDivider() {
    Divider(
        Modifier
            .fillMaxWidth()
            .padding(16.dp), color = Color(0xFF3F51B5)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDropDownMenu() {
    var selectedText by rememberSaveable { mutableStateOf("") }
    var expanded by rememberSaveable { mutableStateOf(false) }
    val desserts = listOf(
        "Ice Cream",
        "Donut",
        "Cupcake",
        "Brownie",
        "Jelly Bean",
        "Lollipop",
        "KitKat",
        "Marshmallow",
        "Nougat",
        "Oreo",
        "Pie"
    )

    Column(Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            desserts.forEach { dessert ->
                DropdownMenuItem(text = { Text(text = dessert) }, onClick = {
                    expanded = false
                    selectedText = dessert
                })
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun OtherComponentsPreview() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyCard()
        MyBadgeBox()
        MyDivider()
        MyDropDownMenu()
    }
}