package com.example.todo_clean

import android.content.Context
import androidx.room.Room
import com.example.todo_clean.data.ToDoRepositoryImp
import com.example.todo_clean.data.database.MyDatabase
import com.example.todo_clean.data.database.ToDoDao
import com.example.todo_clean.data.database.mapper.ToDoEntityToToDo
import com.example.todo_clean.data.database.mapper.ToDoToToDoEntity
import com.example.todo_clean.domain.interactor.CreateToDo
import com.example.todo_clean.domain.interactor.GetAllToDo
import com.example.todo_clean.domain.repository.Repository

object InjectionUtil {
    private lateinit var context: Context

    val getAllToDo: GetAllToDo by lazy {
        GetAllToDo(repository = repoImpl)
    }
    val createToDo: CreateToDo by lazy {
        CreateToDo(repository = repoImpl)
    }
    fun inject(activity: MainActivity) {
        context = activity.applicationContext
        activity.getAllToDo = getAllToDo
        activity.createToDo = createToDo
    }
    val database: MyDatabase by lazy {
        Room.databaseBuilder(
            context,
            MyDatabase::class.java, "Simple.db"
        ).allowMainThreadQueries().build()
    }
    val dao: ToDoDao by lazy{
       database.dao()
    }
    val repoImpl: Repository by lazy {
        ToDoRepositoryImp(
            dao,
            todoEntityToToDo = ToDoEntityToToDo(),
            toDoToToDoEntity = ToDoToToDoEntity()
        )
    }
}