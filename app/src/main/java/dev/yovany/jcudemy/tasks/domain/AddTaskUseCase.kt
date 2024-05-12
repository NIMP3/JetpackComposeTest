package dev.yovany.jcudemy.tasks.domain

import dev.yovany.jcudemy.tasks.data.TaskRepository
import dev.yovany.jcudemy.tasks.ui.model.TaskModel
import javax.inject.Inject

class AddTaskUseCase @Inject constructor(private val taskRepository: TaskRepository) {
    suspend operator fun invoke(task: TaskModel) {
        taskRepository.addTask(task)
    }
}