package com.example.todo_clean.domain.repository

import com.example.todo_clean.domain.entity.ToDo

interface Repository {
    fun getAllToDo(): List<ToDo>
    fun createToDo(toDo: ToDo): String
}