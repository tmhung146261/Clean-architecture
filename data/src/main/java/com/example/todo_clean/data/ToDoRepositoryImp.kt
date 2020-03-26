package com.example.todo_clean.data

import com.example.todo_clean.data.database.ToDoDao
import com.example.todo_clean.data.database.ToDoEntity
import com.example.todo_clean.data.database.mapper.ToDoEntityToToDo
import com.example.todo_clean.data.database.mapper.ToDoToToDoEntity
import com.example.todo_clean.domain.entity.ToDo
import com.example.todo_clean.domain.repository.Repository
import java.util.*

class ToDoRepositoryImp(
    private val dao: ToDoDao,
    private val toDoToToDoEntity : ToDoToToDoEntity,
    private val todoEntityToToDo: ToDoEntityToToDo
) : Repository {
    // if don't complete api is should imp by in memory
    val todos = mutableListOf<ToDo>()
    override fun getAllToDo(): List<ToDo> {
        val todoEntitys: List<ToDoEntity> = dao.getAllToDo()
        return todoEntitys.map { entity ->
            todoEntityToToDo.map(entity)
        }
       // return todos
    }

    override fun createToDo(toDo: ToDo): String {
        val toDoEntity = toDoToToDoEntity.map(toDo)
        dao.createToDo(toDoEntity)
            /*val id = UUID.randomUUID().toString().substring(0,5)
            todos.add(toDo.copy(identity = id))*/
        return ""
    }

}