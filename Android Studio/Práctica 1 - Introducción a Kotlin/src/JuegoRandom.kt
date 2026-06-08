/*
Problema 2 - Piedra, Papel o Tijera
Autor: Favio André Solórzano Vilca
Fecha de creación: 28/03/2026
Fecha de modificación: 29/03/2026
Descripción: Juego simple donde el usuario compite contra la máquina.
*/

import java.util.Random

// Genera la elección de la máquina
fun eleccionMaquina(): String {
    val numero = Random().nextInt(3) + 1
    return when (numero) {
        1 -> "Piedra"
        2 -> "Papel"
        else -> "Tijera"
    }
}

// Solicita la elección del jugador
fun eleccionJugador(): String {
    println("¿Qué opción quiere jugar?")
    println("1 = Piedra\n2 = Papel\n3 = Tijera")

    val jugada = readln().toInt()

    return when (jugada) {
        1 -> "Piedra"
        2 -> "Papel"
        else -> "Tijera"
    }
}

// Determina el resultado del juego
fun decisionFinal(jugador: String, maquina: String) {
    println("\nTú elegiste: $jugador")
    println("Máquina eligió: $maquina")

    when {
        jugador == maquina -> println("¡Empate!")
        jugador == "Piedra" && maquina == "Tijera" -> println("¡Ganaste!")
        jugador == "Papel" && maquina == "Piedra" -> println("¡Ganaste!")
        jugador == "Tijera" && maquina == "Papel" -> println("¡Ganaste!")
        else -> println("¡Perdiste!")
    }
}

// Función principal
fun main() {
    var opcion: String

    do {
        val maquina = eleccionMaquina()
        val jugador = eleccionJugador()
        decisionFinal(jugador, maquina)

        println("\n¿Deseas jugar otra vez? (s/n)")
        opcion = readln()

    } while (opcion == "s")
}