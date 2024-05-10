package dev.yovany.jcudemy.tasks.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.yovany.jcudemy.ui.instagram.ui.model.TaskModel
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(): ViewModel() {
    private val  _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog

    private val _tasks = mutableStateListOf<TaskModel>()
    val tasks: List<TaskModel> = _tasks

    fun onDialogClicked(flag: Boolean) {
        _showDialog.value = flag
    }

    fun onTaskCreated(task: String) {
        onDialogClicked(false)
        _tasks.add(TaskModel(task = task))
    }

    fun onTaskCompleted(task: TaskModel) {
        val index = _tasks.indexOf(task)
        _tasks[index] = _tasks[index].let { it.copy(completed = !it.completed) }
    }

    fun onTaskRemoved(task: TaskModel) {
        val taskToRemove = _tasks.find { it.id == task.id }
        _tasks.remove(taskToRemove)
    }
}