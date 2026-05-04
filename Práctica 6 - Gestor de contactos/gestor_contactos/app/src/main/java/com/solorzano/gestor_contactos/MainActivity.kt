// Descripción: Actividad principal que inicializa la navegación entre pantallas
//              usando NavHost y NavController de Jetpack Compose.
// Autor: Favio Solórzano Vilca
// Fecha de creación: 2026-05-03
// Fecha de última modificación: 2026-05-03

package com.solorzano.gestor_contactos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.solorzano.gestor_contactos.ui.theme.Gestor_contactosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Gestor_contactosTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // NavController maneja la navegación entre pantallas
                    val navController = rememberNavController()

                    // NavHost define las rutas disponibles en la app
                    NavHost(
                        navController = navController,
                        startDestination = "lista"
                    ) {
                        composable("lista") {
                            ListaScreen(navController = navController)
                        }
                        composable("formulario") {
                            FormularioScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}
