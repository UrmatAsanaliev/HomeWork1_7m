package com.example.homework1_7m.data.mapper

import com.example.homework1_7m.data.model.NoteEntity
import com.example.homework1_7m.domain.model.Note

class NoteMapper {

    fun noteToNoteEntity(note: Note) = NoteEntity(
        id= note.id,
        title = note.title,
        description = note.description,
        creationDate = note.creationDate
    )

    fun noteEntityToNote(note: NoteEntity) = Note(
        id= note.id,
        title = note.title,
        description = note.description,
        creationDate = note.creationDate
    )
}