package com.example.mynote

object NotesStore {

    private var notes: List<String> = emptyList()

    private var onNotesUpdated: ((List<String>) -> Unit)? = null

    fun addNote(note:String) {
        notes = listOf(note) + notes

        onNotesUpdated?.invoke(notes)
    }

    fun getNote() = notes

    fun addNotesUpdateListener(listener: ((List<String>) -> Unit)? = null) {
        onNotesUpdated = listener
    }
}