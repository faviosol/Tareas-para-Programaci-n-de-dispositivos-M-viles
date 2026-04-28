package com.solorzano.formulario_con_compose.model

/**
 * Modelo de datos que representa a un usuario del formulario.
 * Almacena toda la información capturada en los campos de registro.
 */
data class UsuarioModel(
    val nombre: String,  // Nombre completo del usuario
    val edad: Int,       // Edad en años
    val correo: String,  // Correo electrónico
    val genero: String,  // Género seleccionado (Masculino, Femenino, Otro)
    val activo: Boolean, // Indica si el usuario está activo
    val nivel: Int       // Nivel de experiencia del 0 al 10
)
