package com.bytebusters.android.mpsystem.dto.response.api

import java.time.LocalDateTime

class ToDoTaskDto (
    var id: Long? = null,
    var title: String? = null,
    var description: String? = null,
    var dueDate: LocalDateTime? = null,
    var isCompleted: Boolean? = null,
    var createdAt: LocalDateTime? = null
)