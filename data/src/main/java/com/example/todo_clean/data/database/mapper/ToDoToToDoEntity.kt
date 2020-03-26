package com.example.todo_clean.data.database.mapper

import com.example.todo_clean.data.database.ToDoEntity
import com.example.todo_clean.domain.entity.ToDo

class ToDoToToDoEntity {
    fun map(todo: ToDo): ToDoEntity {
        return ToDoEntity(
           id = 0,
           title = todo.title,
           isDone = todo.isDone
        )
    }
}