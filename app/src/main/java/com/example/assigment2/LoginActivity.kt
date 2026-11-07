package com.example.assigment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login_layout)

        val username: TextView = findViewById(R.id.username_id)

        val password: TextView = findViewById(R.id.password_id)

        val validationText: TextView = findViewById(R.id.verification_id)

        val loginButton: Button = findViewById(R.id.loginButton_id)
        loginButton.backgroundTintList = null
        loginButton.setOnClickListener {
            Login(username.text.toString(), password.text.toString())
            if (UserDataBase.activeUser != null)
            {
                setResult(RESULT_OK, null)
                finish()
                intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            }
            else
            {
                validationText.text = "Email or Password incorect"
            }
        }
    }

    fun Login(email: String, password: String)
    {
        UserDataBase.database.forEach {
            if(it.email == email && it.password == password)
            {
                UserDataBase.activeUser = it
            }
        }
    }
}