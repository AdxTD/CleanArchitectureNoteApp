package com.taha.cleanarchitecturenoteapp.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.taha.cleanarchitecturenoteapp.ui.theme.*

@Entity
data class Note(
    @PrimaryKey val id :Int? = null,
    val title:String,
    val content:String,
    val timestamp:Long,
    val color:Int
){
    companion object{
        val noteColors = listOf(RedPink, BabyBlue, Violet, LightGreen, RedOrange)
    }
}

class InvalidNoteException(message: String) : Exception(message)
