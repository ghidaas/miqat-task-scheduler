package org.example.tasks.service

import org.example.tasks.dto.TaskRequest
import org.example.tasks.dto.TaskResponse

interface TaskService {
    fun create(request: TaskRequest): TaskResponse
    fun getAll(): List<TaskResponse>
    fun getById(id: Long): TaskResponse?

}