package ru.yandex.architectureproject.domain

import kotlinx.coroutines.delay
import ru.yandex.architectureproject.data.repository.TaskRepository

class CompleteTaskUseCase(
    private val repository: TaskRepository,
) {
    suspend operator fun invoke(taskId: Int) {
        repository.completeTask(taskId)

        delay(DELETE_DELAY_MS)
        repository.deleteTask(taskId)
    }

    companion object {
        private const val DELETE_DELAY_MS = 10 * 1000L
    }
}
