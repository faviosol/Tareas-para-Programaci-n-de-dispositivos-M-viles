// Descripción: Pantalla principal que muestra la lista de contactos.
//              Permite marcar favoritos, eliminar contactos con confirmación,
//              buscar por nombre y navegar al formulario de registro.
// Autor: Favio Solórzano Vilca
// Fecha de creación: 2026-05-03
// Fecha de última modificación: 2026-05-03

package com.solorzano.gestor_contactos

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaScreen(navController: NavController) {

    // Lista inicial de contactos de ejemplo
    var contactos by remember {
        mutableStateOf(
            listOf(
                Contacto(1, "Ana García", "987 654 321", false),
                Contacto(2, "Carlos López", "912 345 678", true),
                Contacto(3, "María Martínez", "965 432 109", false),
                Contacto(4, "Pedro Sánchez", "934 567 890", false)
            )
        )
    }

    // Texto ingresado en el buscador
    var textoBusqueda by remember { mutableStateOf("") }

    // Contacto seleccionado para confirmar eliminación
    var contactoAEliminar by remember { mutableStateOf<Contacto?>(null) }

    // Filtra por nombre y ordena favoritos primero
    val contactosFiltrados = contactos
        .filter { it.nombre.contains(textoBusqueda, ignoreCase = true) }
        .sortedByDescending { it.favorito }

    // Diálogo de confirmación antes de eliminar
    if (contactoAEliminar != null) {
        AlertDialog(
            onDismissRequest = { contactoAEliminar = null },
            title = { Text("Eliminar contacto") },
            text = { Text("¿Deseas eliminar a ${contactoAEliminar!!.nombre}?") },
            confirmButton = {
                TextButton(onClick = {
                    contactos = contactos.filter { it.id != contactoAEliminar!!.id }
                    contactoAEliminar = null
                }) {
                    Text("Eliminar", color = Color.Red)
                }
            },
            dismissButton = {
                TextButton(onClick = { contactoAEliminar = null }) {
                    Text("Cancelar")
                }
            }
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Gestor de Contactos") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("formulario") }) {
                Icon(Icons.Default.Add, contentDescription = "Agregar contacto")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            // Contador de contactos y favoritos
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Total: ${contactos.size}",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Favoritos: ${contactos.count { it.favorito }}",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFFFFC107),
                    fontWeight = FontWeight.Bold
                )
            }

            // Campo de búsqueda por nombre
            OutlinedTextField(
                value = textoBusqueda,
                onValueChange = { textoBusqueda = it },
                label = { Text("Buscar contacto") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Buscar") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                singleLine = true
            )

            // Mensaje cuando no hay contactos
            if (contactosFiltrados.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (textoBusqueda.isEmpty()) "No hay contactos registrados"
                               else "No se encontró \"$textoBusqueda\"",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Gray
                    )
                }
            } else {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(contactosFiltrados, key = { it.id }) { contacto ->
                        ContactoItem(
                            contacto = contacto,
                            onEliminar = { contactoAEliminar = contacto },
                            onToggleFavorito = {
                                contactos = contactos.map {
                                    if (it.id == contacto.id) it.copy(favorito = !it.favorito) else it
                                }
                            }
                        )
                        Divider()
                    }
                }
            }
        }
    }
}

@Composable
fun ContactoItem(
    contacto: Contacto,
    onEliminar: () -> Unit,
    onToggleFavorito: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = contacto.nombre, style = MaterialTheme.typography.titleMedium)
            Text(text = contacto.telefono, style = MaterialTheme.typography.bodyMedium)
        }

        // Ícono de favorito: amarillo si está marcado, gris si no
        IconButton(onClick = onToggleFavorito) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Favorito",
                tint = if (contacto.favorito) Color(0xFFFFC107) else Color.LightGray
            )
        }

        // Ícono de eliminar: abre el diálogo de confirmación
        IconButton(onClick = onEliminar) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Eliminar",
                tint = Color.Red
            )
        }
    }
}
