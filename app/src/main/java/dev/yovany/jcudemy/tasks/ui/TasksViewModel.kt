package dev.yovany.jcudemy.tasks.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.yovany.jcudemy.data.Message
import dev.yovany.jcudemy.data.MessageType
import dev.yovany.jcudemy.tasks.domain.AddTaskUseCase
import dev.yovany.jcudemy.tasks.domain.DeleteTaskUseCase
import dev.yovany.jcudemy.tasks.domain.GetTasksUseCase
import dev.yovany.jcudemy.tasks.domain.UpdateTaskUseCase
import dev.yovany.jcudemy.tasks.ui.TasksUIState.Error
import dev.yovany.jcudemy.tasks.ui.TasksUIState.Loading
import dev.yovany.jcudemy.tasks.ui.TasksUIState.Success
import dev.yovany.jcudemy.tasks.ui.model.TaskModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(
    private val addTaskUseCase: AddTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
    getTasksUseCase: GetTasksUseCase
): ViewModel() {

    val uiState: StateFlow<TasksUIState> = getTasksUseCase().map { tasks ->
        if (tasks.isEmpty()) Error(Message(title = "INFORMATION", description = "No tasks found", type = MessageType.INFO))
        else Success(tasks)
    }
        .catch { Error(Message(title = "ERROR", description = it.message ?: "An error occurred", type = MessageType.ERROR)) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), Loading) as StateFlow<TasksUIState>

    private val  _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog

    fun onDialogClicked(flag: Boolean) {
        _showDialog.value = flag
    }

    fun onTaskCreated(task: String) {
        onDialogClicked(false)

        viewModelScope.launch {
            addTaskUseCase(TaskModel(task = task))
        }
    }

    fun onTaskCompleted(task: TaskModel) {
        viewModelScope.launch {
            updateTaskUseCase(task.copy(completed = !task.completed))
        }
    }

    fun onTaskRemoved(task: TaskModel) {
        viewModelScope.launch {
            deleteTaskUseCase(task)
        }
    }
}