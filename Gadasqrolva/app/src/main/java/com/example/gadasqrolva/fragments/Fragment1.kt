package com.example.gadasqrolva.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.gadasqrolva.R




class Fragment1 : Fragment(R.layout.fragment_1) {
    private lateinit var editTextLetter: EditText
    private lateinit var buttonSave: Button
    private lateinit var textViewLetter: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextLetter = view.findViewById(R.id.editTextLetter)
        buttonSave = view.findViewById(R.id.buttonSave)
        textViewLetter = view.findViewById(R.id.textViewLetter)

        val sharedPreferences =
            this.getActivity()?.getSharedPreferences("APP_PR", Context.MODE_PRIVATE);

        val letters = sharedPreferences?.getString("notes", "")

        textViewLetter.text = letters

        buttonSave.setOnClickListener {
            val letter = editTextLetter.text.toString()
            val savedText = textViewLetter.text.toString()
            val result = "$letter \n $savedText"

            textViewLetter.text = result

            sharedPreferences?.edit()
                ?.putString("notes", result)
                ?.apply()
        }
    }
}