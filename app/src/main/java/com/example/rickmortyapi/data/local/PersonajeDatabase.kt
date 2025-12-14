package com.example.rickmortyapi.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [PersonajeEntity::class],
    version = 1,
    exportSchema = false
)
abstract class PersonajeDatabase: RoomDatabase(){
    abstract fun PersonajeDao(): PersonajeDao
}