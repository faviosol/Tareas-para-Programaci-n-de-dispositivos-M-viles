/*
Problema 4 - Adivinar el número
Autor: Favio André Solórzano Vilca
Fecha de creación: 28/03/2026
Fecha de modificación: 29/03/2026
Descripción: Juego donde el usuario debe adivinar un número aleatorio.
*/

import java.util.Random

fun main() {
    val numeroSecreto = Random().nextInt(30) + 1

    println("=== Juego: Adivina el número ===")

    for (intento in 1..5) {
        print("Intento $intento - Ingresa un número del 1 al 30: ")
        val numeroUsuario = readln().toInt()

        if (numeroUsuario == numeroSecreto) {
            println("¡Ganaste, felicitaciones!")
            return
        } else if (numeroUsuario < numeroSecreto) {
            println("El número es mayor")
        } else {
            println("El número es menor")
        }
    }

    println("GAME OVER, el número era $numeroSecreto")
}