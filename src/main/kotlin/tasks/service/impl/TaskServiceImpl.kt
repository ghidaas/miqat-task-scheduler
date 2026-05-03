package org.example.tasks.service.impl

import java.time.Instant
import org.example.tasks.dto.TaskRequest
import org.example.tasks.dto.TaskResponse
import org.example.tasks.entity.TaskEntity
import org.example.tasks.enum.TaskStatusEnum
import org.example.tasks.repository.TaskRepository
import org.example.tasks.service.TaskService
import org.jobrunr.scheduling.JobScheduler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TaskServiceImpl: TaskService {
    @Autowired
    lateinit var  taskRepository : TaskRepository
    @Autowired lateinit var  jobScheduler   : JobScheduler
    override fun create(request: TaskRequest): TaskResponse {
        val task = TaskEntity().apply {
            name        = request.name
            description = request.description
            scheduledAt = request.scheduledAt
            status      = TaskStatusEnum.PENDING
        }
        val saved = taskRepository.save(task)

        jobScheduler.schedule(request.scheduledAt) {
            executeTask(saved.id!!)
        }

        return TaskResponse.from(saved)
    }

    override   fun getAll(): List<TaskResponse> =
        taskRepository.findAll().map { TaskResponse.from(it) }

    override fun getById(id: Long): TaskResponse? =
        taskRepository.findById(id).map { TaskResponse.from(it) }.orElse(null)

     fun executeTask(id: Long) {
        val task = taskRepository.findById(id).orElseThrow()
        task.status = TaskStatusEnum.RUNNING
        taskRepository.save(task)

        try {
            println("Executing task: ${task.name}")
            task.status = TaskStatusEnum.DONE
        } catch (e: Exception) {
            task.status = TaskStatusEnum.FAILED
            throw e
        } finally {
            taskRepository.save(task)
        }
    }
}
