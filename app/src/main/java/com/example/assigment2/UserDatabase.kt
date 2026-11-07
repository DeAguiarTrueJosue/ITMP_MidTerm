#!/usr/bin/env kotlin
package com.example.assigment2

import java.util.UUID
import java.util.Vector

data class Task(
    var name: String,
    var description: String,
    val id: UUID
)

data class User(
    var name: String,
    var email: String,
    var password: String,
    val id: UUID,
    var tasks: MutableList<Task>
)

class UserDataBase() {
    companion object {
        val database: Array<User> = arrayOf(
            User(
                "Josue", "josue.pipi@gmail.com", "WonderPika", UUID.randomUUID(),
                mutableListOf(
                    Task(
                        "Assignment 1",
                        "Assignment 1 available for portifolio class due Monday",
                        UUID.randomUUID()
                    )
                )
            ),
            User(
                "Juan", "juan.pipi@gmail.com", "WonderPika", UUID.randomUUID(),
                mutableListOf(
                    Task(
                        "Assignment 1",
                        "Assignment 1 available for portifolio class due Monday",
                        UUID.randomUUID()
                    )
                )
            ),
            User(
                "Daniel", "daniel.pipi@gmail.com", "WonderPika", UUID.randomUUID(),
                mutableListOf(
                    Task(
                        "Assignment 1",
                        "Assignment 1 available for portifolio class due Monday",
                        UUID.randomUUID()
                    )
                )
            ),
            User(
                "Zina", "zina.pipi@gmail.com", "WonderPika", UUID.randomUUID(),
                mutableListOf(
                    Task(
                        "Assignment 1",
                        "Assignment 1 available for portifolio class due Monday",
                        UUID.randomUUID()
                    )
                )
            ),
            User(
                "Wei", "wei.pipi@gmail.com", "WonderPika", UUID.randomUUID(),
                mutableListOf(
                    Task(
                        "Assignment 1",
                        "Assignment 1 available for portifolio class due Monday",
                        UUID.randomUUID()
                    )
                )
            ),
            User(
                "Riley", "riley.pipi@gmail.com", "WonderPika", UUID.randomUUID(),
                mutableListOf(
                    Task(
                        "Assignment 1",
                        "Assignment 1 available for portifolio class due Monday",
                        UUID.randomUUID()
                    )
                )
            )
        )

        var activeUser: User? = null
    }
}