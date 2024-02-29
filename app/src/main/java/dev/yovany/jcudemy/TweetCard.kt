package dev.yovany.jcudemy

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

@Composable
fun TweetCard() {
    Column(Modifier.fillMaxWidth().padding(bottom = 16.dp)) {
        Row(
            Modifier.padding(16.dp),
            horizontalArrangement = spacedBy(8.dp)
        ) {
            TweetImage()
            TweetContent()
        }
        Divider()
    }
}

@Composable
fun TweetContent() {
    Column {
        TweetHeader()
        TweetBody()
        TweetActions()
    }
}

@Composable
fun TweetActions() {
    Row(Modifier.padding(horizontal = 4.dp, vertical = 8.dp)) {
        TweetAction(
            resources = listOf(R.drawable.ic_chat, R.drawable.ic_chat_filled),
            colors = listOf(Color.Gray),
            counter = 20,
            modifier = Modifier.weight(1f)
        )
        TweetAction(
            resources = listOf(R.drawable.ic_rt),
            colors = listOf(Color.Gray, Color.Green),
            counter = 10,
            modifier = Modifier.weight(1f)
        )
        TweetAction(
            resources = listOf(R.drawable.ic_like, R.drawable.ic_like_filled),
            colors = listOf(Color.Gray, Color.Red),
            counter = 30,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun TweetAction(
    resources: List<Int>,
    colors: List<Color>,
    counter: Int,
    modifier: Modifier = Modifier
) {
    val icons = if (resources.size == 1) listOf(resources[0], resources[0]) else resources
    var icon by remember { mutableStateOf(icons[0]) }

    val iconColors = if (colors.size == 1) listOf(colors[0], colors[0]) else colors
    var color by remember { mutableStateOf(iconColors[0]) }

    var count by remember { mutableStateOf(counter) }
    var isChecked by remember { mutableStateOf(false) }

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "Comment",
            tint = color,
            modifier = Modifier.clickable {
                isChecked = !isChecked
                icon = if (isChecked) icons[1] else icons[0]
                color = if (isChecked) iconColors[1] else iconColors[0]
                count += if (isChecked) 1 else -1
            })
        Text(text = count.toString(), fontSize = 12.sp, modifier = Modifier.padding(start = 4.dp))
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun TweetHeader() {
    Row(horizontalArrangement = spacedBy(4.dp)) {
        Text(text = "Yovany", fontSize = 12.sp, fontWeight = FontWeight.Bold)
        Text(text = "@YovanyDev", fontSize = 12.sp)
        Text(text = "2h", fontSize = 12.sp)
        Spacer(modifier = Modifier.weight(1f))
        Icon(painter = painterResource(id = R.drawable.ic_dots), contentDescription = "More")
    }
}

@Composable
fun TweetBody() {
    Column(verticalArrangement = spacedBy(4.dp)) {
        Text(
            text = "This city will be the future of technology, here. We can find the best developers and the best companies.",
            fontSize = 14.sp
        )
        Image(
            painter = painterResource(id = R.drawable.img_tweet1),
            contentDescription = "Tweet Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
        )
    }
}

@Composable
fun TweetImage() {
    Image(
        painter = painterResource(id = R.drawable.img_user1),
        contentDescription = "Profile Image",
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape)
    )
}

@Preview(showBackground = true)
@Composable
fun TweetCardPreview() {
    TweetCard()
}
