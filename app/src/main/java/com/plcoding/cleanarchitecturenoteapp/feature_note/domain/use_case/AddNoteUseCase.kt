package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.InvalidNoteException
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository

class AddNoteUseCase (
    private val noteRepository: NoteRepository
) {

    @kotlin.jvm.Throws(InvalidNoteException::class )
    suspend operator fun invoke(note: Note){
        if(note.title.isBlank() || note.content.isBlank())
            throw InvalidNoteException("Title and content should not be empty!")
        noteRepository.insertNote(note)
    }
}