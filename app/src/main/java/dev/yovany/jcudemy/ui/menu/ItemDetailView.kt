package dev.yovany.jcudemy.ui.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yovany.jcudemy.data.Item
import dev.yovany.jcudemy.data.Menu
import dev.yovany.jcudemy.ui.components.CustomButtonView
import dev.yovany.jcudemy.ui.components.CustomDialogView
import dev.yovany.jcudemy.ui.components.CustomImageView
import dev.yovany.jcudemy.ui.components.CustomProgressBarView
import dev.yovany.jcudemy.ui.components.CustomSliderView
import dev.yovany.jcudemy.ui.components.CustomTextAndTextFieldView
import dev.yovany.jcudemy.ui.components.OtherComponentsView
import dev.yovany.jcudemy.ui.components.SelectionControlComponentsView

@Composable
fun ItemDetailView(name: String, description: String, onBackClicked: () -> Unit = {}) {
    Column(Modifier.fillMaxSize()) {
        Header(name, description, onBackClicked)
        Body(name)
    }
}

@Composable
fun Body(name: String) {
    Column(Modifier.fillMaxSize()) {
        when (name) {
            "Button" -> CustomButtonView()
            "Dialogs" -> CustomDialogView()
            "Image" -> CustomImageView()
            "Progress Bar" -> CustomProgressBarView()
            "Slider" -> CustomSliderView()
            "Text - TextField" -> CustomTextAndTextFieldView()
            "Other Components" -> OtherComponentsView()
            "Selection Control Components" -> SelectionControlComponentsView()
        }
    }
}


@Composable
fun Header(name: String, description: String, onBackClicked: () -> Unit = {}) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Filled.ArrowBackIosNew,
                contentDescription = "Back",
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { onBackClicked() }
            )
            Column {
                Text(name, style = MaterialTheme.typography.titleMedium)
                Text(
                    description,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Light
                )
            }
        }

        HorizontalDivider(thickness = 0.2.dp, color = MaterialTheme.colorScheme.onBackground)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ItemDetailViewPreview() {
    val item = Item(1, "Text - TextField", "A composable that displays a string of text.")
    ItemDetailView(item.name, item.description)
}