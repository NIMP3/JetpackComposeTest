package dev.yovany.jcudemy.ui.instagram.ui.model

data class TaskModel(
    val id: Long = System.currentTimeMillis(),
    val task: String,
    var completed: Boolean = false
)
