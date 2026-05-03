package org.example.tasks.entity

import java.util.Date
import org.example.tasks.enum.TaskStatusEnum
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.PrePersist
import jakarta.persistence.PreUpdate
import jakarta.persistence.EnumType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import java.sql.Time
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.*
import org.example.tasks.enum.TaskPriorityEnum


@Entity
@Table(name = "tasks")
class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    val id: Long? = null

    @NotNull
    @Column(name = "name") var name: String? = null

    @NotNull @Column(name = "description") var description: String? = null

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    var status: TaskStatusEnum? = TaskStatusEnum.PENDING

    @Column(name = "scheduled_at") var scheduledAt: LocalDateTime? = null

    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    var priority: TaskPriorityEnum? = TaskPriorityEnum.MEDIUM

    @Column(name = "created_at", updatable = false, nullable = false) var createdAt: Date? = null

    @Column(name = "updated_at") var updatedAt: Date? = null

    @PrePersist
    private fun onCreate() {
        updatedAt = Date()
        createdAt = updatedAt
    }

    @PreUpdate
    private fun onUpdate() {
        updatedAt = Date()
    }
}
