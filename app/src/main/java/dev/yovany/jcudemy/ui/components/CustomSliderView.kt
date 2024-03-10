package dev.yovany.jcudemy.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MySlider() {
    var sliderValue by rememberSaveable { mutableStateOf(0f) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it }
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Text(text = "${(sliderValue * 100).toInt()}%", fontSize = 24.sp)
    }
}

@Composable
fun MyAdvancedSlider() {
    var sliderValue by rememberSaveable { mutableFloatStateOf(0f) }
    var completeValue by rememberSaveable { mutableFloatStateOf(0f) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            onValueChangeFinished = { completeValue = sliderValue },
            valueRange = 0f..0.5f,
            steps = 9
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Text(text = "${(completeValue * 100).toInt()}%", fontSize = 24.sp)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyRangeSlider() {
    var max by rememberSaveable { mutableFloatStateOf(0.5f) }
    var min by rememberSaveable { mutableFloatStateOf(0f) }
    var range by remember { mutableStateOf(min..max) }


    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        RangeSlider(
            value = range, onValueChange = { range = it },
            onValueChangeFinished = { min = range.start; max = range.endInclusive },
            valueRange = 0f..1f,
            steps = 9
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = "${(range.start * 100).toInt()}% - ${(range.endInclusive * 100).toInt()}%",
            fontSize = 24.sp
        )
    }
}

@Composable
fun CustomSliderView() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
    ) {
        MySlider()
        MyAdvancedSlider()
        MyRangeSlider()
    }
}

@Preview(showBackground = true)
@Composable
fun MyCustomSliderPreview() {
    CustomSliderView()
}
