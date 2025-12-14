package com.example.rickmortyapi.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/*
Define todas las operaciones que puedes hacer con la tabla:
1. Insertar, 2. Leer, 3. Borrar, 4 Observar cambios
para que Room sepa que operaciones SQL ejecutar
 */

@Dao
interface PersonajeDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(personaje: PersonajeEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(personaje: List<PersonajeEntity>)

    @Delete
    suspend fun delete(personaje: PersonajeEntity): Int

    @Query("SELECT * FROM personaje")
    suspend fun getAll(): List<PersonajeEntity>

    @Query("SELECT * FROM personaje")
    fun observeAll(): Flow<List<PersonajeEntity>>

    @Query("SELECT * FROM personaje WHERE id = :id")
    suspend fun readPersonajeById(id: Long): PersonajeEntity?

    @Query("DELETE FROM personaje")
    suspend fun deleteAll()
}