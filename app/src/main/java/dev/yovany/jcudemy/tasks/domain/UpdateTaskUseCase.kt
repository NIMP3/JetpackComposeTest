package dev.yovany.jcudemy.tasks.domain

import dev.yovany.jcudemy.tasks.data.TaskRepository
import dev.yovany.jcudemy.tasks.ui.model.TaskModel
import javax.inject.Inject

class UpdateTaskUseCase @Inject constructor(private val taskRepository: TaskRepository) {
    suspend operator fun invoke(taskModel: TaskModel) {
        taskRepository.updateTask(taskModel)
    }
}