package com.example.todo_clean.data.database.mapper

import com.example.todo_clean.data.database.ToDoEntity
import com.example.todo_clean.domain.entity.ToDo

class ToDoEntityToToDo {
    fun map(toDoEntity: ToDoEntity): ToDo {
        return ToDo(
            identity = toDoEntity.toString(),
            title = toDoEntity.title,
            isDone = toDoEntity.isDone
        )
    }
}