package com.example.rickmortyapi.data.local

class PersonajeNotFoundException(
    message: String = "Personaje no encontrado"
): RuntimeException(message)

//// Uso en el archivo necesario:
//if (entity == null) {
//    throw PokemonNotFoundException()  // ← Lanzar error personalizado
//}