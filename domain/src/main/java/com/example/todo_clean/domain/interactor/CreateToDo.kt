package com.example.todo_clean.domain.interactor

import com.example.todo_clean.domain.entity.ToDo
import com.example.todo_clean.domain.repository.Repository
import java.lang.IllegalArgumentException

class CreateToDo(
    val repository: Repository
) {
    fun excute(title: String) {
        if(title.isBlank()) {
            throw IllegalArgumentException("title is not empty")
        }
        val todo = ToDo(
            identity = "",
            title = title,
            isDone = false
        )
        repository.createToDo(todo)
    }
}