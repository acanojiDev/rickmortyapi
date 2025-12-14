package com.example.rickmortyapi.di

import android.content.Context
import androidx.room.Room
import com.example.rickmortyapi.data.local.PersonajeDao
import com.example.rickmortyapi.data.local.PersonajeDatabase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)  // ← Crea una sola instancia para toda la app
class DatabaseModule {

    @Provides
    @Singleton
    fun providePersonajeDatabase(@ApplicationContext context: Context): PersonajeDatabase {
        // Cuando alguien pida PersonajeDatabase, usa este método
        return Room.databaseBuilder(
            context,
            PersonajeDatabase::class.java,
            "rickandmorty_database"  // ← Nombre del archivo en disco
        ).build()
    }

    @Provides
    @Singleton
    fun providePersonajeDao(database: PersonajeDatabase): PersonajeDao {
        // Cuando alguien pida PersonajeDao, usa este método
        // Hilt automáticamente pasa la BD que creó arriba
        return database.PersonajeDao()
    }
}