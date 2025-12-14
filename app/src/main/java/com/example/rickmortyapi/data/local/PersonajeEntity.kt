package com.example.rickmortyapi.data.local

/*
Define como se ve un personaje guarado en la BD local,
para que Room sepa que columnas crear en la tabla
 */

@Entity("personaje")
data class PersonajeEntity(
    @PrimaryKey
    val id: Long,
    val name: String,
    val gender: String?,
    val status: String?,
    val imageUrl: String?
)

fun Personaje.toEntity(): PersonajeEntity{
    return PersonajeEntity(
        id = this.id,
        name = this.name,
        gender = this.gender,
        status = this.status,
        imageUrl = this.imageUrl
    )
}

fun List<Personaje>.toEntity():List<PersonajeEntity> = this.map(Personaje::toEntity)

fun PersonajeEntity.toModel(): Personaje {
    return Personaje(
        id = this.id,
        name = this.name,
        gender = this.gender,
        status = this.status,
        imageUrl = this.imageUrl
    )
}

fun List<PersonajeEntity>.toModel(): List<Personaje> {
    return this.map(PersonajeEntity::toModel)
}