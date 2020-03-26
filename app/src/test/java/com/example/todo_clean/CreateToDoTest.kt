package com.example.todo_clean
import com.example.todo_clean.domain.entity.ToDo
import com.example.todo_clean.domain.interactor.CreateToDo
import com.example.todo_clean.domain.repository.Repository
import org.junit.Assert
import org.junit.Test

class CreateToDoTest {
    @Test
    fun `should Throw Exception TitleIs Empty '   ' `() {
        val usecase = CreateToDo(
            repository = object : Repository {
                override fun getAllToDo(): List<ToDo> {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
                override fun createToDo(toDo: ToDo): String {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            }
        )
        var throwed = false
        try {
            usecase.invoke("   ")
        }catch (e: Throwable) {
            throwed = true
            Assert.assertEquals("title is not empty",e.message)
        }
        Assert.assertTrue(throwed == true)
    }

    @Test
    fun `call to repository when data is valid`() {
        var calledToCreateWith: ToDo? = null
        val usercase = CreateToDo(repository = object : Repository{
            override fun getAllToDo(): List<ToDo> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun createToDo(toDo: ToDo): String {
                calledToCreateWith = toDo
                return ""
            }

        })
        val input = "test"
        val expect = ToDo(
            identity = "",
            title = input,
            isDone = false
        )
        usercase.invoke(input)
        Assert.assertEquals(expect, calledToCreateWith)
    }
}