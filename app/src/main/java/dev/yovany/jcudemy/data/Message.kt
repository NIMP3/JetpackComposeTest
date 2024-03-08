package dev.yovany.jcudemy.data

import dev.yovany.jcudemy.R

data class Message(
    val title: String,
    val description: String,
    val type: MessageType
)

enum class MessageType(val animation: Int) {
    INFO(R.raw.info),
    SUCCESS(R.raw.check),
    WARNING(R.raw.warning),
    LOADING(R.raw.loading),
    ERROR(R.raw.error)
}