package com.example.rickmortyapi.data

import com.example.rickmortyapi.data.model.Personaje
import kotlinx.coroutines.flow.Flow

/*
Define el contrato(interfaz) que dice Cualquier clase que lea datos de personaje
DEBE tener estos metodos porque tanto Personajes en local como api siguen la misma
estructura
 */

interface PersonajeDataSource{
    suspend fun addAll(personajeList: List<Personaje>)
    //Todos deben poder guardar personaje

    fun observe(): Flow<Result<List<Personaje>>>
    //Poder obsertvar cambios

    suspend fun readAll(): Result<List<Personaje>>

    suspend fun readOne(id: Long): Result<Personaje>

    suspend fun isError()
    //Deben poder reportar errores
}