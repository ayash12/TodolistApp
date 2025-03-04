package com.example.todolist.domain.repository

import com.example.todolist.data.database.TaskDao
import com.example.todolist.data.model.Task
import com.example.todolist.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
class TaskRepositoryImpl @Inject constructor(private val taskDao: TaskDao) : TaskRepository {
    override fun getAllTasks(): Flow<List<Task>> = taskDao.getAllTasks()
    override suspend fun insertTask(task: Task) = taskDao.insertTask(task)
    override suspend fun deleteTask(task: Task) = taskDao.deleteTask(task)
//    override suspend fun updateTask(task: Task) = taskDao.updateTask(task)
}