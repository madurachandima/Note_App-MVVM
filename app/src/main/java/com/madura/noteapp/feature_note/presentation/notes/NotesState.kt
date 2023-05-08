package com.madura.noteapp.feature_note.presentation.notes

import com.madura.noteapp.feature_note.domain.model.Note
import com.madura.noteapp.feature_note.domain.util.NoteOrder
import com.madura.noteapp.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSelectionVisible: Boolean = false
)
