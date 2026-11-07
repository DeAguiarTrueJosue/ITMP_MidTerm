package com.example.assigment2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import java.util.UUID

interface RemoveButton
{
    fun RemoveButtonFun(taskID: UUID)
}

class ToDo(mytask : Task) : Fragment() {

    lateinit var nameText : TextView
    lateinit var descriptionText : TextView
    lateinit var removeMeButton: Button
    lateinit var listener : RemoveButton
    val task: Task = mytask

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is RemoveButton)
            listener = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View?
    {
        val inflated = inflater.inflate(R.layout.fragment_to_do, container, false)

        nameText = inflated.findViewById(R.id.TaskName)
        nameText.text = task.name

        descriptionText = inflated.findViewById(R.id.TaskDescription)
        descriptionText.text = task.description

        removeMeButton = inflated.findViewById(R.id.RemoveMe)
        removeMeButton.setOnClickListener {
            listener.RemoveButtonFun(task.id)
        }

        return inflated
    }
}