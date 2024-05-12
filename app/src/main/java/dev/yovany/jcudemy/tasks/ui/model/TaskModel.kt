package dev.yovany.jcudemy.tasks.ui.model

import dev.yovany.jcudemy.tasks.data.TaskEntity

data class TaskModel(
    val id: Int = System.currentTimeMillis().hashCode(),
    val task: String,
    var completed: Boolean = false
) {
    companion object {
        fun fromTaskEntity(taskEntity: TaskEntity): TaskModel {
            return TaskModel(
                id = taskEntity.id,
                task = taskEntity.task,
                completed = taskEntity.completed
            )
        }
    }
}
