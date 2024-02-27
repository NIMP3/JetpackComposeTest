package dev.yovany.jcudemy.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ComponentsScreen() {
    Column {
        ComponentHeader(
            modifier = Modifier
                .weight(0.4f)
                .fillMaxWidth()
        )
        ComponentBody(
            modifier = Modifier
                .weight(0.6f)
                .fillMaxWidth()
        )
    }

}

@Composable
fun ComponentBody(modifier: Modifier) {
    Column(
        modifier = modifier
            .background(Color(0xFFE8EAF6))
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {

    }
}

@Composable
fun ComponentHeader(modifier: Modifier) {
    Column(
        modifier = modifier.background(Color(0xFF3F51B5)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Components", style = MaterialTheme.typography.titleLarge, color = Color.White)
        Text(
            text = "This is a list of all the components",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White
        )
    }
}

@Composable
fun ComponentItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(
            contentColor = Color(0xFF000000),
            containerColor = Color(0xFFF1F1F1)
        ),
        border = BorderStroke(1.dp, Color(0xFF7A89F1))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Component Name",
                style = MaterialTheme.typography.titleLarge,
                color = Color(0xFF3F51B5),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "This is a description of the component that is being displayed in the list",
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFF747474)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComponentItemPreview() {
    ComponentItem()
}

@Preview(showBackground = true)
@Composable
fun ComponentsScreenPreview() {
    ComponentsScreen()
}