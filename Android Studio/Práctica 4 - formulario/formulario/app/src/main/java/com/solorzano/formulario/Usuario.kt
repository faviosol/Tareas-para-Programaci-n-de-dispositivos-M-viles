/*
* Descripción: Data class que representa un usuario con sus datos principales
* Autor: Favio André Solórzano Vilca
* Fecha creación: 20/04/2026
* Última modificación: 20/04/2026
*/

package com.solorzano.formulario

import java.io.Serializable

data class Usuario(
    val nombre: String,
    val edad: String,
    val ciudad: String,
    val correo: String
) : Serializable