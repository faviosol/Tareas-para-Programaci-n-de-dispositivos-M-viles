// Descripción: Pantalla de formulario para registrar un nuevo contacto.
//              Valida que los campos no estén vacíos antes de guardar.
// Autor: Favio Solórzano Vilca
// Fecha de creación: 2026-05-03
// Fecha de última modificación: 2026-05-03

package com.solorzano.gestor_contactos

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormularioScreen(navController: NavController) {

    var nombre by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }

    // Controla si se deben mostrar errores de validación
    var mostrarErrores by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Nuevo Contacto") },
                navigationIcon = {
                    // Botón para regresar a la pantalla anterior
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Regresar")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                isError = mostrarErrores && nombre.isBlank(),
                supportingText = {
                    if (mostrarErrores && nombre.isBlank()) {
                        Text("El nombre es obligatorio")
                    }
                }
            )

            OutlinedTextField(
                value = telefono,
                onValueChange = { telefono = it },
                label = { Text("Teléfono") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                isError = mostrarErrores && telefono.isBlank(),
                supportingText = {
                    if (mostrarErrores && telefono.isBlank()) {
                        Text("El teléfono es obligatorio")
                    }
                }
            )

            Button(
                onClick = {
                    if (nombre.isBlank() || telefono.isBlank()) {
                        // Muestra errores si algún campo está vacío
                        mostrarErrores = true
                    } else {
                        navController.popBackStack()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar")
            }
        }
    }
}
