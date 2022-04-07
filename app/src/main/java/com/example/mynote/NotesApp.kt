package com.example.mynote

import android.app.Application

class NotesApp: Application() {

    override fun onCreate() {
        super.onCreate()

        NotesStore.initialize(application = this )
    }
}