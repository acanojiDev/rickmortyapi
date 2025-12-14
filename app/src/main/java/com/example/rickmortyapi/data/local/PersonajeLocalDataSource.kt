package com.example.rickmortyapi.data.local

import com.example.rickmortyapi.data.PersonajeDataSource
import com.example.rickmortyapi.data.model.Personaje
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

//Encargado de leer y escribir en la BD
class PersonajeLocalDataSource @Inject constructor(
    private val personajeDao: PersonajeDao
): PersonajeDataSource{
    override suspend fun addAll(personajeList: List<Personaje>) {
        personajeDao.insert(personajeList.toEntity())
    }

    override fun observe(): Flow<Result<List<Personaje>>> {
        return personajeDao.observeAll()
            .map {entities ->
                try {
                    Result.success(entities.toModel())
                }catch  (e:Exception){
                    Result.failure(e)
                }
            }
    }


    override suspend fun readAll(): Result<List<Personaje>> {
        return try {
            val entities = personajeDao.getAll()
            Result.success(entities.toModel())
        }catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun readOne(id: Long): Result<Personaje> {
        return try{
            val entity = personajeDao.readPersonajeById(id)
            if(entity!=null){
                Result.success(entity.toModel())
            }else{
                Result.failure(PersonajeNotFoundException())
            }
        }catch (e: Exception){
            Result.failure(e)
        }
    }

    override suspend fun isError() {
        TODO("Not yet implemented")
    }

    suspend fun deletePersonaje(id:Long){
        val entity = personajeDao.readPersonajeById(id)
        if(entity!=null){
            personajeDao.delete(entity)
        }
    }

    suspend fun refreshAll(personajeList: List<Personaje>){
        personajeDao.deleteAll()
        personajeDao.insert(personajeList.toEntity())
    }
}