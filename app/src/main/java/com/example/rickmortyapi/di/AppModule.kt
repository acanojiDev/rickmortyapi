package com.example.rickmortyapi.di

import com.example.rickmortyapi.data.PersonajeDataSource
import com.example.rickmortyapi.data.local.PersonajeLocalDataSource
import com.example.rickmortyapi.data.remote.PersonajeRemoteDataSource
import com.example.rickmortyapi.data.repository.PersonajeRepository
import com.example.rickmortyapi.data.repository.PersonajeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Singleton
    @Binds
    @RemoteDataSource
    abstract fun bindsRemotePersonajeRemoteDataSource(ds: PersonajeRemoteDataSource): PersonajeDataSource

    @Singleton
    @Binds
    @LocalDataSource
    abstract fun bindsLocalPersonajeRemoteDataSource(ds: PersonajeLocalDataSource): PersonajeDataSource

    @Binds
    @Singleton
    abstract fun bindPersonajeRepository(repository: PersonajeRepositoryImpl): PersonajeRepository
    //abstract fun bindPokemonRepository(repository: PokemonFakeRemoteRepository): PokemonRepository
    //abstract fun bindPokemonRepository(repository: PokemonInMemoryRepository): PokemonRepository
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LocalDataSource

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RemoteDataSource