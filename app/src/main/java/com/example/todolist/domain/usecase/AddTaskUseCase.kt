package com.example.todolist.domain.usecase

import com.example.todolist.data.model.Task
import com.example.todolist.domain.repository.TaskRepository
import javax.inject.Inject
class AddTaskUseCase @Inject constructor(private val repository: TaskRepository) {
    suspend operator fun invoke(task: Task) = repository.insertTask(task)
}