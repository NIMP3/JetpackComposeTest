package dev.yovany.jcudemy.tasks.ui

import dev.yovany.jcudemy.data.Message
import dev.yovany.jcudemy.tasks.ui.model.TaskModel

sealed interface TasksUIState {
    object Loading: TasksUIState
    data class Error(val message: Message): TasksUIState
    data class Success(val tasks: List<TaskModel>): TasksUIState
}