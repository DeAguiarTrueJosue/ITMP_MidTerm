package com.example.assigment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.profile_layout)
        val nameField : TextView = findViewById(R.id.NameField)
        nameField.text = UserDataBase.activeUser?.name
        val emailField : TextView = findViewById(R.id.EmailField)
        emailField.text = UserDataBase.activeUser?.email
        val IDField : TextView = findViewById(R.id.IDField)
        IDField.text = UserDataBase.activeUser?.id.toString()
        val backButton : Button = findViewById(R.id.profileBackButton_id)
        backButton.setOnClickListener {
            finish()
        }
        val logOutButton : Button = findViewById(R.id.logOutButton)
        logOutButton.setOnClickListener {
            finish()
            UserDataBase.activeUser = null
            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        }
    }
