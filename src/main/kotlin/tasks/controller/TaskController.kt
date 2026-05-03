package org.example.tasks.controller

import org.example.tasks.dto.TaskRequest
import org.example.tasks.dto.TaskResponse
import org.example.tasks.enum.TaskStatusEnum
import org.example.tasks.service.TaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user/tasks")
class TaskController {
    @Autowired lateinit var  taskService: TaskService


        @PostMapping
        fun create(@RequestBody request: TaskRequest): ResponseEntity<TaskResponse> =
            ResponseEntity.ok(taskService.create(request))

        @GetMapping
        fun getAll(): ResponseEntity<List<TaskResponse>> =
            ResponseEntity.ok(taskService.getAll())

        @GetMapping("/{id}")
        fun getById(@PathVariable id: Long): ResponseEntity<TaskResponse> {
            val task = taskService.getById(id) ?: return ResponseEntity.notFound().build()
            return ResponseEntity.ok(task)
        }
    }
