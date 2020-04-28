package com.ilham.jpro.mynoteapps.ui.insert

import android.app.Application
import androidx.lifecycle.ViewModel
import com.ilham.jpro.mynoteapps.database.Note
import com.ilham.jpro.mynoteapps.repository.NoteRepository

class NoteAddUpdateViewModel(application: Application) : ViewModel() {
    private val mNoteRepository: NoteRepository = NoteRepository(application)

    fun insert(note: Note) {
        mNoteRepository.insert(note)
    }

    fun update(note: Note) {
        mNoteRepository.update(note)
    }

    fun delete(note: Note) {
        mNoteRepository.delete(note)
    }
}