package org.example.tasks.dto

import java.sql.Time
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.Date

data class TaskRequest(
    val name        : String?,
    val description : String?,
    val scheduledAt : LocalDateTime?,
)