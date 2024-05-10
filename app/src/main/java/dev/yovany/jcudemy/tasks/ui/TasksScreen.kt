package dev.yovany.jcudemy.tasks.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import dev.yovany.jcudemy.ui.instagram.ui.model.TaskModel

@Composable
fun TasksScreen(tasksViewModel: TasksViewModel) {
    val showDialog: Boolean by tasksViewModel.showDialog.observeAsState(initial = false)
    val tasks: List<TaskModel> = tasksViewModel.tasks

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        AddTasksDialog(
            show = showDialog,
            onDismiss = { tasksViewModel.onDialogClicked(false) }) { task ->
            tasksViewModel.onTaskCreated(task)
        }
        TasksList(
            tasks = tasks,
            onTaskCompleted = { task -> tasksViewModel.onTaskCompleted(task) },
            onTaskClicked = { },
            onTaskLongPressed = {
                tasksViewModel.onTaskRemoved(it)
            })
        FabDialog(modifier = Modifier.align(Alignment.BottomEnd)) {
            tasksViewModel.onDialogClicked(true)
        }
    }
}

@Composable
fun TasksList(
    tasks: List<TaskModel>,
    onTaskCompleted: (TaskModel) -> Unit,
    onTaskClicked: (TaskModel) -> Unit,
    onTaskLongPressed: (TaskModel) -> Unit
) {
    LazyColumn {
        items(tasks, key = { it.id }) { task ->
            TaskItem(
                task = task,
                onTaskCompleted = onTaskCompleted,
                onTaskClicked = onTaskClicked,
                onTaskLongPressed = onTaskLongPressed
            )
        }
    }
}

@Composable
fun TaskItem(
    task: TaskModel,
    onTaskCompleted: (TaskModel) -> Unit,
    onTaskClicked: (TaskModel) -> Unit,
    onTaskLongPressed: (TaskModel) -> Unit
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .border(1.dp, Color.LightGray, RoundedCornerShape(10))
            .clickable { onTaskClicked(task) }
            .pointerInput(Unit) {
                detectTapGestures(
                    onLongPress = { onTaskLongPressed(task) }
                )
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            modifier = Modifier.padding(vertical = 4.dp),
            checked = task.completed,
            onCheckedChange = { onTaskCompleted(task) })
        Text(
            text = task.task,
            fontSize = 16.sp,
            style = TextStyle(textDecoration = if (task.completed) TextDecoration.LineThrough else TextDecoration.None),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}

@Composable
fun FabDialog(modifier: Modifier = Modifier, onAddTask: () -> Unit) {
    FloatingActionButton(onClick = onAddTask, modifier = modifier) {
        Icon(Icons.Filled.Add, contentDescription = "")
    }
}

@Composable
fun AddTasksDialog(show: Boolean, onDismiss: () -> Unit, onAddTask: (String) -> Unit) {
    var task by remember { mutableStateOf("") }
    if (!show) return

    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(5))
                .background(Color.White)
                .padding(24.dp)
        ) {
            Text(
                text = "Add Task",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(8.dp))
            TextField(
                value = task,
                onValueChange = { task = it },
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.LightGray, RoundedCornerShape(10))
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Button(
                onClick = {
                    if (task.isNotEmpty()) onAddTask(task)
                    onDismiss()
                    task = ""
                },
                shape = RoundedCornerShape(24),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(text = "ADD")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TasksScreenPreview() {
    TasksScreen(TasksViewModel())
}