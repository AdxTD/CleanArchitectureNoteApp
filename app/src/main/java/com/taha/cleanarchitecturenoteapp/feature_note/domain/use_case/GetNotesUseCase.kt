package com.taha.cleanarchitecturenoteapp.feature_note.domain.use_case

import com.taha.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.taha.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import com.taha.cleanarchitecturenoteapp.feature_note.domain.util.NoteOrder
import com.taha.cleanarchitecturenoteapp.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUseCase (
    private val noteRepository: NoteRepository
) {

    operator fun invoke(noteOrder: NoteOrder = NoteOrder.Date(orderType = OrderType.Descending )) : Flow<List<Note>>{
        val notes = noteRepository.getAllNotes().map { notes ->
            when(noteOrder.orderType) {
                is OrderType.Ascending -> when (noteOrder) {
                    is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                    is NoteOrder.Color -> notes.sortedBy { it.color }
                    is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                }
                is OrderType.Descending -> when (noteOrder) {
                    is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                    is NoteOrder.Color -> notes.sortedByDescending { it.color }
                    is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                }
            }
        }
        return notes
    }

}