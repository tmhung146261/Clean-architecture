package com.example.todo_clean.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao()
interface ToDoDao {
    @Query("SELECT * FROM todo")
    fun getAllToDo(): List<ToDoEntity>

    @Insert
    fun createToDo(toDoEntity: ToDoEntity)
}