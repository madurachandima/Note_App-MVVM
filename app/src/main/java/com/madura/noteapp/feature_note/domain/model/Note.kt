package com.madura.noteapp.feature_note.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.madura.noteapp.ui.theme.BabyBlue
import com.madura.noteapp.ui.theme.LightGreen
import com.madura.noteapp.ui.theme.RedOrange
import com.madura.noteapp.ui.theme.RedPink
import com.madura.noteapp.ui.theme.Violet

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException(message: String) : Exception(message)

