package dev.yovany.jcudemy

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun SimpleRecyclerView() {
    val leagues = League.createLeagues()
    var position by rememberSaveable { mutableStateOf(0) }
    val rvState = rememberLazyListState()
    val coroutinesScope = rememberCoroutineScope()
    val showHeader by remember {
        derivedStateOf {
            rvState.firstVisibleItemIndex > 0
        }
    }

    Column(Modifier.fillMaxSize()) {
        if (!showHeader) Header(league = leagues[position])
        Teams(teams = leagues[position].teams, modifier = Modifier.weight(1f), rvState = rvState)
        Divider(color = Color.LightGray, thickness = 0.4.dp)
        Leagues(leagues = leagues) { league ->
            position = leagues.indexOf(league)
            coroutinesScope.launch {
                rvState.animateScrollToItem(0)
            }
        }
    }

}

@Composable
fun Header(league: League) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(league.color)) {
        Text(
            text = league.name,
            modifier = Modifier.padding(16.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.White
        )
    }
}

@Composable
fun Leagues(leagues: List<League>, onLeagueSelected: (League) -> Unit = {}) {
    LazyRow(
        Modifier
            .fillMaxWidth()
            .background(Color(0xFF3D3D3D))
            .padding(top = 8.dp, bottom = 4.dp, start = 8.dp)
    ) {
        items(leagues) { league ->
            League(league = league, onLeagueSelected = onLeagueSelected)
        }
    }
}

@Composable
fun League(league: League, onLeagueSelected: (League) -> Unit = {}) {
    Card(
        Modifier
            .padding(vertical = 16.dp, horizontal = 4.dp)
            .border(1.dp, league.color, RoundedCornerShape(12.dp))
            .clickable { onLeagueSelected(league) },
        elevation = CardDefaults.cardElevation(8.dp),
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            contentColor = Color.White,
            containerColor = Color(0xFF3D3D3D)
        )
    ) {
        Text(
            text = league.name,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Teams(teams: List<Team>, modifier: Modifier = Modifier, rvState: LazyListState = rememberLazyListState()) {
    val teamList = teams.groupBy { it.status }

    LazyColumn(
        state = rvState,
        modifier = modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth()
    ) {
        teamList.forEach{ (status, teams) ->
            stickyHeader {
                Text(
                    text = status,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF3D3D3D))
                        .padding(16.dp),
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            items(teams) { team ->
                Team(team = team, position = teams.indexOf(team) + 1)
            }
        }
    }


}

@Composable
fun Team(team: Team, position: Int) {
    Column {
        Divider(color = Color.LightGray, thickness = 0.4.dp)
        Row(
            Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(RoundedCornerShape(30))
                    .border(1.dp, team.colors.first(), RoundedCornerShape(30)),
                contentAlignment = Alignment.Center
            ) {
                Row {
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(team.colors.first()))
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(team.colors.last()))
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(team.colors.first()))
                }
                Box(modifier = Modifier
                    .size(18.dp)
                    .clip(RoundedCornerShape(30))
                    .background(Color.White),
                    contentAlignment = Alignment.Center) {

                    Text(
                        text = position.toString(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp,
                        color = Color.Black)
                }
            }
            Text(text = team.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleRecyclerViewPreview() {
    SimpleRecyclerView()
}