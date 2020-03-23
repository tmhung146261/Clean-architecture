package com.example.todo_clean.domain.entity

data class ToDo(
    val identity: String,
    val title: String,
    val isDone: Boolean
)