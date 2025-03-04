package com.example.todolist.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todolist.presentation.viewmodel.TaskViewModel
import kotlinx.coroutines.flow.forEach

@Composable
fun TaskScreen(viewModel: TaskViewModel) {
    var taskTitle by remember { mutableStateOf("") }
    val tasks by viewModel.tasks.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    if (taskTitle.isNotBlank()) {
                        viewModel.addTask(taskTitle)
                        taskTitle = ""  // Reset input setelah tambah task
                    }
                }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Task")
            }
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues).padding(16.dp)) {
            BasicTextField(
                value = taskTitle,
                onValueChange = { taskTitle = it },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Column {
                tasks.forEach { task ->
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(task.title)
                        Button(onClick = { viewModel.deleteTask(task) }) {
                            Text("Delete")
                        }
                    }
                }
            }
        }
    }
}
