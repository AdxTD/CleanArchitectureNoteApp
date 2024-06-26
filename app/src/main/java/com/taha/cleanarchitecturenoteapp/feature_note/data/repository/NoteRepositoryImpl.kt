package com.taha.cleanarchitecturenoteapp.feature_note.data.repository

import com.taha.cleanarchitecturenoteapp.feature_note.data.data_source.NoteDao
import com.taha.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.taha.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val noteDao: NoteDao
) : NoteRepository{

    override fun getAllNotes(): Flow<List<Note>> = noteDao.getAllNotes()

    override suspend fun getNoteById(noteId: Int): Note? {
        return noteDao.getNoteById(noteId)
    }

    override suspend fun insertNote(note: Note) = noteDao.insertNote(note)

    override suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)
}