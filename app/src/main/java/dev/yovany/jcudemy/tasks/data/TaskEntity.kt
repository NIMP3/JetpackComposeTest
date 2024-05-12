package dev.yovany.jcudemy.tasks.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.yovany.jcudemy.tasks.ui.model.TaskModel

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey
    val id: Int,
    val task: String,
    var completed: Boolean = false
) {
    companion object {
        fun fromTaskModel(taskModel: TaskModel): TaskEntity {
            return TaskEntity(
                id = taskModel.id,
                task = taskModel.task,
                completed = taskModel.completed
            )
        }
    }
}
