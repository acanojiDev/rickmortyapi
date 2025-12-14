package com.example.rickmortyapi.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rickmortyapi.ui.personajeList.PersonajeListScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "personaje_list"  // Primera pantalla
    ) {
        composable("personaje_list") {  // Ruta
            PersonajeListScreen()        // ¿Qué mostrar?
        }
    }
}