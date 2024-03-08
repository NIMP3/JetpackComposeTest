package dev.yovany.jcudemy.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yovany.jcudemy.CheckInfo

@Composable
fun MySwitch() {
    var state by rememberSaveable { mutableStateOf(false) }

    Switch(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color(0xFF06A888),
            checkedTrackColor = Color(0xFF046854),
            uncheckedThumbColor = Color(0xFFA0A0A0),
            uncheckedTrackColor = Color(0xFF505050),
            disabledCheckedTrackColor = Color(0xFF06A888),
            disabledCheckedThumbColor = Color(0xFF046854),
            disabledUncheckedTrackColor = Color(0xFFFFFFFF),
            disabledUncheckedThumbColor = Color(0xFFD1D1D1),
        )
    )
}

@Composable
fun MyCheckBox() {
    var state by rememberSaveable { mutableStateOf(true) }

    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color(0xFF06A888),
            uncheckedColor = Color(0xFFA0A0A0),
            checkmarkColor = Color(0xFF046854),
            disabledCheckedColor = Color(0xFF06A888),
            disabledUncheckedColor = Color(0xFFD1D1D1),
        )
    )
}

@Composable
fun MyCheckBoxWithText() {
    var state by rememberSaveable { mutableStateOf(false) }

    Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "Acepto los términos y condiciones")
    }
}

@Composable
fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {
    Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) }
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = checkInfo.title)
    }
}

@Composable
fun MyListOfCheckbox() {
    val teams = listOf("Barcelona", "Real Madrid", "Bayern Munich", "PSG", "Manchester United")
    val checkInfo = getOptions(teams)

    Column {
        teams.forEachIndexed { index, team ->
            MyCheckBoxWithTextCompleted(checkInfo[index])
        }
    }
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map { title ->
        var status by rememberSaveable { mutableStateOf(false) }

        CheckInfo(
            title = title,
            selected = status,
            onCheckedChange = { status = it }
        )
    }
}

@Composable
fun MyTriStatusCheckbox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }

    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.Off -> ToggleableState.On
            ToggleableState.On -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.Off
        }
    })
}

@Composable
fun MyRadioButton(selected: Boolean, title: String, onClick: (String) -> Unit = { }) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = selected,
            onClick = { onClick(title) },
            enabled = true,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color(0xFF06A888),
                unselectedColor = Color(0xFFA0A0A0),
                disabledSelectedColor = Color(0xFF06A888),
                disabledUnselectedColor = Color(0xFFD1D1D1),
            )
        )

        Spacer(modifier = Modifier.width(4.dp))

        Text(text = title)
    }
}

@Composable
fun MyListOfRadioButton() {
    var selected by rememberSaveable { mutableStateOf("Barcelona") }

    Column {
        MyRadioButton(
            selected == "Barcelona",
            "Barcelona",
            onClick = { selected = it })
        MyRadioButton(
            selected == "Real Madrid",
            "Real Madrid",
            onClick = { selected = it })
        MyRadioButton(
            selected == "Bayern Munich",
            "Bayern Munich",
            onClick = { selected = it })
        MyRadioButton(selected == "PSG",
            "PSG",
            onClick = { selected = it })
        MyRadioButton(
            selected == "Manchester United",
            "Manchester United",
            onClick = { selected = it })
    }
}

@Composable
fun SelectionControlComponentsView() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment . CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ) {
                MySwitch()
                Spacer(modifier = Modifier.padding(8.dp))
                MyCheckBox()
                Spacer(modifier = Modifier.padding(8.dp))
                MyCheckBoxWithText()
                Spacer(modifier = Modifier.padding(8.dp))
                MyListOfCheckbox()
                Spacer(modifier = Modifier.padding(8.dp))
                MyTriStatusCheckbox()
                Spacer(modifier = Modifier.padding(8.dp))
                MyListOfRadioButton()
            }
}


@Preview(showBackground = true)
@Composable
fun SelectionControlComponentsViewPreview() {
    SelectionControlComponentsView()
}