package com.solorzano.formulario_con_compose.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
/**
 * Pantalla principal del formulario de registro.
 * Contiene todos los campos, validaciones y componentes de Compose.
 */

@OptIn(ExperimentalMaterial3Api::class) // sin esta linea aparece en rojo 3 lineas de abajo
@Composable
fun FormularioScreen() {

    // Estados de los campos de texto
    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }

    // Estados de los componentes adicionales
    var genero by remember { mutableStateOf("") }
    var aceptaTerminos by remember { mutableStateOf(false) }
    var usuarioActivo by remember { mutableStateOf(false) }
    var nivel by remember { mutableStateOf(0f) }

    // Estado del resultado final
    var resultado by remember { mutableStateOf("") }

    // Validaciones de cada campo
    val nombreValido = nombre.isNotBlank()
    val edadValida = edad.isNotBlank() && edad.toIntOrNull() != null
    val correoValido = correo.contains("@")

    // El formulario es válido solo si todos los campos son correctos
    val formularioValido = nombreValido && edadValida && correoValido && aceptaTerminos

    // Lista de opciones para el género
    val generos = listOf("Masculino", "Femenino", "Otro")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        // Título del formulario
        Text(
            text = "Formulario de Registro",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        // Campo nombre con contador de caracteres y validación
        OutlinedTextField(
            value = nombre,
            onValueChange = { if (it.length <= 30) nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth(),
            isError = nombre.isNotEmpty() && !nombreValido,
            supportingText = {
                if (nombre.isNotEmpty() && !nombreValido)
                    Text("El nombre no puede estar vacío", color = Color.Red)
                else
                    Text("${nombre.length}/30")
            }
        )

        // Campo edad, solo acepta números
        OutlinedTextField(
            value = edad,
            onValueChange = { edad = it },
            label = { Text("Edad") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            isError = edad.isNotEmpty() && !edadValida,
            supportingText = {
                if (edad.isNotEmpty() && !edadValida)
                    Text("Ingresa solo números", color = Color.Red)
            }
        )

        // Campo correo, debe contener @ para ser válido
        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo electrónico") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            isError = correo.isNotEmpty() && !correoValido,
            supportingText = {
                if (correo.isNotEmpty() && !correoValido)
                    Text("El correo debe contener @", color = Color.Red)
            }
        )

        // Selección de género con RadioButton
        Text("Género:", fontWeight = FontWeight.Medium)
        generos.forEach { opcion ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                RadioButton(
                    selected = genero == opcion,
                    onClick = { genero = opcion }
                )
                Text(text = opcion)
            }
        }

        // Slider para seleccionar nivel de experiencia del 0 al 10
        Text("Nivel de experiencia: ${nivel.toInt()}", fontWeight = FontWeight.Medium)
        Slider(
            value = nivel,
            onValueChange = { nivel = it },
            valueRange = 0f..10f,
            steps = 9,
            modifier = Modifier.fillMaxWidth()
        )

        // Switch para indicar si el usuario está activo o inactivo
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Usuario activo", fontWeight = FontWeight.Medium)
            Switch(
                checked = usuarioActivo,
                onCheckedChange = { usuarioActivo = it }
            )
        }

        // Checkbox para aceptar términos, requerido para enviar el formulario
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = aceptaTerminos,
                onCheckedChange = { aceptaTerminos = it }
            )
            Text("Acepto los términos y condiciones")
        }
        if (!aceptaTerminos) {
            Text(
                "Debes aceptar los términos para continuar",
                color = Color.Red,
                fontSize = 12.sp
            )
        }

        // Botón enviar habilitado solo cuando el formulario es válido
        // Botón limpiar resetea todos los campos al estado inicial
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {
                    val estado = if (usuarioActivo) "activo" else "inactivo"
                    resultado = "Usuario ${nombre}, ${edad} años, ${estado}, nivel ${nivel.toInt()}"
                },
                enabled = formularioValido,
                modifier = Modifier.weight(1f)
            ) {
                Text("Enviar")
            }

            OutlinedButton(
                onClick = {
                    nombre = ""
                    edad = ""
                    correo = ""
                    genero = ""
                    aceptaTerminos = false
                    usuarioActivo = false
                    nivel = 0f
                    resultado = ""
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Limpiar")
            }
        }

        // Muestra el resultado en una tarjeta de color verde si es válido
        if (resultado.isNotEmpty()) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = if (formularioValido) Color(0xFFE8F5E9) else Color(0xFFFFEBEE)
                )
            ) {
                Text(
                    text = resultado,
                    modifier = Modifier.padding(16.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = if (formularioValido) Color(0xFF2E7D32) else Color(0xFFC62828)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

    } // fin Column
} // fin FormularioScreen