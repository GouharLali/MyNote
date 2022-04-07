package com.example.mynote

import android.app.Application
import android.content.SharedPreferences
import androidx.core.content.edit

object NotesStore {

    private const val PREFERENCES_KEY = "preferences"
    private const val SAVED_NOTES_KEY = "saved_notes"


    private var sharedPreferences: SharedPreferences? = null

    private var notes: List<String> = emptyList()
        set(value) {
            field = value

            sharedPreferences?.edit {
                putStringSet(SAVED_NOTES_KEY, value.toSet())
            }
        }

    private var onNotesUpdated: ((List<String>) -> Unit)? = null

    fun initialize(application: Application) {
        sharedPreferences =
            application.getSharedPreferences(PREFERENCES_KEY, Application.MODE_PRIVATE );

        notes = sharedPreferences!!.getStringSet(SAVED_NOTES_KEY, emptySet() )!!.toList()
    }

    fun addNote(note:String) {
        notes = listOf(note) + notes

        onNotesUpdated?.invoke(notes)
    }

    fun getNote() = notes

    fun addNotesUpdateListener(listener: ((List<String>) -> Unit)? = null) {
        onNotesUpdated = listener
    }
}