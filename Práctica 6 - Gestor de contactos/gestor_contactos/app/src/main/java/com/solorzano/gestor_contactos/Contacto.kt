// Descripción: Modelo de datos que representa un contacto dentro de la aplicación.
//              Incluye nombre, teléfono e indicador de favorito.
// Autor: Favio Solórzano Vilca
// Fecha de creación: 2026-05-03
// Fecha de última modificación: 2026-05-03

package com.solorzano.gestor_contactos

/**
 * Representa un contacto en el gestor.
 *
 * @param id         Identificador único generado automáticamente para evitar colisiones al
 *                   eliminar contactos con el mismo nombre y teléfono.
 * @param nombre     Nombre completo del contacto.
 * @param telefono   Número telefónico del contacto.
 * @param favorito   Indica si el contacto está marcado como favorito (se muestra primero en la lista).
 */
data class Contacto(
    val id: Int,
    val nombre: String,
    val telefono: String,
    val favorito: Boolean = false
)
