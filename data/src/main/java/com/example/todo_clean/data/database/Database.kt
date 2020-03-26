package com.example.todo_clean.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ToDoEntity::class], version = 1 )
abstract class  MyDatabase: RoomDatabase() {
    abstract fun dao(): ToDoDao
}