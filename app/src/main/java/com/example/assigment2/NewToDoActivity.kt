package com.example.assigment2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.UUID

class NewToDoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_new_to_do)

        val toDoName : EditText = findViewById(R.id.Name_id)

        val toDoDescription : EditText = findViewById(R.id.Description_id)

        val toDoCreateButton : Button = findViewById(R.id.CreateToDoButton_id)
        toDoCreateButton.setOnClickListener {
            if (toDoName.text.toString() != "" && toDoDescription.text.toString() != ""){
                UserDataBase.activeUser!!.tasks.add(UserDataBase.activeUser!!.tasks.count(),
                    Task(
                        toDoName.text.toString(),
                        toDoDescription.text.toString(),
                    UUID.randomUUID()))
                finish()
            }
        }
    }
}