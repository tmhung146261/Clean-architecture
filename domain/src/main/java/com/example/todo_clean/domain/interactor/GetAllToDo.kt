package com.example.todo_clean.domain.interactor

import com.example.todo_clean.domain.entity.ToDo
import com.example.todo_clean.domain.repository.Repository

class GetAllToDo constructor(
    private val repository: Repository
) {
    fun execute(): List<ToDo> {
        return repository.getAllToDo()
    }
}