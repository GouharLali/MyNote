package com.example.mynote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mynote.databinding.ActivityNoteBinding

class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        val actionbar = supportActionBar
        actionbar!!.title = "Note"
        actionbar.setDisplayHomeAsUpEnabled(true)

        binding.saveButton.setOnClickListener {
            NotesStore.addNote(note = binding.noteEditText.text.toString())

            finish()
        }
    }


}

