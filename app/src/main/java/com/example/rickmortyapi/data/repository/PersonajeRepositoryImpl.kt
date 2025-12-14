package com.example.rickmortyapi.data.repository

import com.example.rickmortyapi.data.PersonajeDataSource
import com.example.rickmortyapi.data.local.PersonajeLocalDataSource
import com.example.rickmortyapi.data.model.Personaje
import com.example.rickmortyapi.data.remote.PersonajeRemoteDataSource
import com.example.rickmortyapi.data.remote.model.PersonajeRemote
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PersonajeRepositoryImpl @Inject constructor(
    private val localDataSource: PersonajeLocalDataSource,    // BD
    private val remoteDataSource: PersonajeRemoteDataSource   // API
) : PersonajeRepository {
    override fun observeAllPersonaje(): Flow<Result<List<Personaje>>> {
        return localDataSource.observe()
    }

    override suspend fun syncPersonajeFromNetwork() {
        val result = remoteDataSource.readAll()  // Llamar API

        result.onSuccess { personajeList ->
            localDataSource.refreshAll(personajeList)  // Actualizar BD
            // observeAllPokemon() automáticamente notifica
        }.onFailure { exception ->
            // Si falla (sin internet): no pasa nada
            // BD se mantiene igual, usuario sigue viendo datos viejos
        }
    }

    override suspend fun readOne(id: Long): Result<Personaje> {
        return localDataSource.readOne(id)
    }

    override suspend fun addPersonaje(personaje: Personaje) {
        localDataSource.addAll(listOf(personaje))
    }

}