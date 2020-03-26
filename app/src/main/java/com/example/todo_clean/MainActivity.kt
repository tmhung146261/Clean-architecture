package com.example.todo_clean

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.todo_clean.domain.interactor.CreateToDo
import com.example.todo_clean.domain.interactor.GetAllToDo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var getAllToDo: GetAllToDo
    lateinit var createToDo: CreateToDo

    override fun onCreate(savedInstanceState: Bundle?) {
        InjectionUtil.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        refreshData()
        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            val content = findViewById<EditText>(R.id.edtContent).text.toString()
            createToDo(content)
            refreshData()
        }
    }

    fun refreshData() {
        val todos = getAllToDo()
        findViewById<TextView>(R.id.txtContent).text = todos.toString()
    }
}
