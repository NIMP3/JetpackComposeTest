package dev.yovany.jcudemy.tasks.data

import dev.yovany.jcudemy.tasks.ui.model.TaskModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepository @Inject constructor(private val taskDao: TaskDao) {

    val tasks: Flow<List<TaskModel>> = taskDao.getTasks()
        .map { taskEntities -> taskEntities.map { taskEntity -> TaskModel.fromTaskEntity(taskEntity) } }


    suspend fun addTask(taskModel: TaskModel) {
        val taskEntity = TaskEntity.fromTaskModel(taskModel)
        taskDao.insertTask(taskEntity)
    }

    suspend fun updateTask(taskModel: TaskModel) {
        val taskEntity = TaskEntity.fromTaskModel(taskModel)
        taskDao.updateTask(taskEntity)
    }

    suspend fun deleteTask(taskModel: TaskModel) {
        val taskEntity = TaskEntity.fromTaskModel(taskModel)
        taskDao.deleteTask(taskEntity)
    }
}