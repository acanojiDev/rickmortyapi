package com.example.rickmortyapi.data.repository

import com.example.rickmortyapi.data.model.Personaje
import kotlinx.coroutines.flow.Flow

interface PersonajeRepository {

    fun observeAllPersonaje(): Flow<Result<List<Personaje>>>
    // ↑ Devuelve Flow de BD (rápido, offline-first)

    suspend fun syncPersonajeFromNetwork()
    // ↑ Sincroniza en background

    suspend fun readOne(id: Long): Result<Personaje>
    // ↑ Lee uno específico

    suspend fun addPersonaje(personaje: Personaje)
    // ↑ Agrega uno
}