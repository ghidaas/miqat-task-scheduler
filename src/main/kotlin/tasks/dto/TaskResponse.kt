package org.example.tasks.dto

import java.time.LocalDateTime
import java.time.LocalTime
import java.util.Date
import java.util.UUID
import org.example.tasks.entity.TaskEntity
import org.example.tasks.enum.TaskStatusEnum

data class TaskResponse(
    val id          : Long?,
    val name        : String?,
    val description : String?,
    val status      : TaskStatusEnum?,
    val scheduledAt : LocalDateTime?,
    val createdAt   : Date?,
    val updatedAt   : Date?,
) {
    companion object {
        fun from(entity: TaskEntity) = TaskResponse(
            id          = entity.id,
            name        = entity.name,
            description = entity.description,
            status      = entity.status,
            scheduledAt = entity.scheduledAt,
            createdAt   = entity.createdAt,
            updatedAt   = entity.updatedAt,
        )
    }
}