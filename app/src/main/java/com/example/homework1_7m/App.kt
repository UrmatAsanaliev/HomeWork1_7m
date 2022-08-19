package com.example.homework1_7m

import android.app.Application
import androidx.room.Room
import com.example.homework1_7m.data.room.NoteDao
import com.example.homework1_7m.data.room.NoteDataBase

class App: Application() {

    companion object{
        lateinit var noteDao: NoteDao
    }
    lateinit var noteDataBase: NoteDataBase

    override fun onCreate() {
        super.onCreate()
        noteDataBase = Room.databaseBuilder(
            this,
            NoteDataBase::class.java,
            "note_database")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        noteDao = noteDataBase.noteDao()
    }
}