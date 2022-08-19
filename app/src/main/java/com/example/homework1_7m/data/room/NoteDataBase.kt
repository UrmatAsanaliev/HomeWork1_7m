package com.example.homework1_7m.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.homework1_7m.data.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDataBase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}