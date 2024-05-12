package dev.yovany.jcudemy.tasks.domain

import dev.yovany.jcudemy.tasks.data.TaskRepository
import javax.inject.Inject

class GetTasksUseCase @Inject constructor(private val taskRepository: TaskRepository) {
    operator fun invoke() = taskRepository.tasks
}