package com.example.rickmortyapi.data.remote.model

data class PersonajeListRemote(
    val results: List<PersonajeListItemRemote>
)

data class PersonajeListItemRemote(
    val name: String,
    val image: String
)

data class PersonajeRemote(
    val id: Long,
    val name: String,
    val status: String,
    val gender: String,
    val image: String
)