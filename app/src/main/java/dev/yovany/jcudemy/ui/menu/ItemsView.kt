package dev.yovany.jcudemy.ui.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yovany.jcudemy.Item
import dev.yovany.jcudemy.Menu.Companion.createSimpleMenu
import dev.yovany.jcudemy.R
import dev.yovany.jcudemy.Service
import dev.yovany.jcudemy.Utility
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemsView(service: Service, onDismiss: () -> Unit = {}, onItemClicked: (Item) -> Unit = {}) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = sheetState,
        containerColor = Color.White,
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(start= 16.dp, bottom = 32.dp)
        ) {
            ItemsHeader(service = service)
            ItemsList(itemList = service.items) { item ->
                onItemClicked(item)
                scope.launch { sheetState.hide() }.invokeOnCompletion {
                    if (!sheetState.isVisible) onDismiss()
                }
            }
        }
    }
}

@Composable
fun ItemsList(itemList: List<Item>, onItemClicked: (Item) -> Unit = {}) {
    LazyRow(Modifier.fillMaxWidth().padding(end = 16.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(itemList) { item ->
            ItemCard(item = item, onItemClicked = onItemClicked)
        }
    }
}

@Composable
fun ItemCard(item: Item, onItemClicked: (Item) -> Unit = {}) {
    Card(
        modifier = Modifier
            .width(120.dp)
            .padding( vertical = 12.dp)
            .border(1.dp, Color.DarkGray, RoundedCornerShape(10))
            .clickable { onItemClicked(item) },
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        shape = RoundedCornerShape(10),
        colors = CardDefaults.cardColors(
            contentColor = Color(0xFFFFFFFF),
            containerColor = Color.White
        )
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_default_item),
                contentDescription = null,
                tint = Color.DarkGray,
                modifier = Modifier.size(48.dp),
            )

            Text(
                text = item.name,
                style = MaterialTheme.typography.titleSmall,
                color = Color.DarkGray,
                fontWeight = FontWeight.SemiBold,
                maxLines = 2,
                minLines = 2,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

    }
}

@Composable
fun ItemsHeader(service: Service) {
    val color: Color = Utility.getColorFromString(service.color)?.let { Color(it) } ?: Color.Black

    Column(Modifier.padding(bottom = 16.dp)) {
        Text(
            text = service.service,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = color
        )
        Text(
            text = service.description,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ItemsViewPreview() {
    val service = createSimpleMenu().services.last()
    ItemsView(service = service)
}