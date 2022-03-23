package com.example.mynote

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.mynote.databinding.ActivityMainBinding
import com.example.mynote.databinding.ActivityNoteBinding

class Note : AppCompatActivity() {

    private lateinit var binding: ActivityNoteBinding

    private var resultTxt: TextView?= null
    private var editText: EditText?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        resultTxt = findViewById(R.id.resultText)
        editText = findViewById(R.id.editText)

        val actionbar = supportActionBar
        actionbar!!.title = "Note"
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    private fun onClick(view: View) {
        var result: String = editText?.text.toString()
        resultTxt?.text = result
    }

}

