package com.example.assigment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.UUID

class HomeActivity : AppCompatActivity(), RemoveButton {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_layout)

        val profileButton: Button = findViewById(R.id.profileBackButton_id)
        profileButton.setOnClickListener {
            if (UserDataBase.activeUser != null) {
                UserDataBase.activeUser!!.tasks.forEach {
                    supportFragmentManager.findFragmentByTag(it.id.toString())?.let {
                        supportFragmentManager
                            .beginTransaction()
                            .remove(it)
                            .commit()
                    }
                }
                val profileIntent = Intent(this, ProfileActivity::class.java)
                startActivityForResult(profileIntent, 10)
            } else {
                val loginIntent = Intent(this, LoginActivity::class.java)
                startActivityForResult(loginIntent, 10)
            }
        }

        val newToDoButton: Button = findViewById(R.id.newToDoButton_id)
        newToDoButton.setOnClickListener {
            if (UserDataBase.activeUser != null) {
                val newTodoIntent = Intent(this, NewToDoActivity::class.java)
                startActivityForResult(newTodoIntent, 10)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (UserDataBase.activeUser != null) {
            UserDataBase.activeUser!!.tasks.forEach {
                supportFragmentManager.findFragmentByTag(it.id.toString())?.let {
                    supportFragmentManager
                        .beginTransaction()
                        .remove(it)
                        .commit()
                }
                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragContainer, ToDo(it), it.id.toString())
                    .commit()
            }
        }
    }

    override fun RemoveButtonFun(taskID: UUID) {
        run taskSearch@{
            UserDataBase.activeUser!!.tasks.forEach {
                if (it.id == taskID) {
                    UserDataBase.activeUser!!.tasks.remove(it)
                    return@taskSearch
                }
            }
        }

        supportFragmentManager.findFragmentByTag(taskID.toString())?.let {
            supportFragmentManager
                .beginTransaction()
                .remove(it)
                .commit()
        }

        onActivityResult(0, 0, null)
    }
}