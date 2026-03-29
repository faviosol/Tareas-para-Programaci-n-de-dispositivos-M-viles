/*
Problema 1 - Evaluación teórica
Autor: Favio André Solórzano Vilca
Fecha de creación: 25/03/2026
Fecha de modificación: 29/03/2026
Descripción: Programa que calcula el nivel de un empleado y el dinero recibido
según sus puntos de desempeño.
*/

// Función que controla el código
fun main() {
    ingresarDatos()
}

// Solicita datos al usuario
fun ingresarDatos() {
    print("Ingresar puntos del empleado (0-10): ")
    val puntos = readln().toInt()

    print("Ingresar salario del empleado: ")
    val salario = readln().toDouble()

    val nivel = obtenerNivelEmpleado(puntos)
    val dinero = calcularDinero(puntos, salario)

    mostrarResultados(nivel, dinero)
}

// Elige nivel de empleado por los puntos
fun obtenerNivelEmpleado(puntos: Int): String {
    return when (puntos) {
        in 0..3 -> "Nivel inaceptable"
        in 4..6 -> "Nivel aceptable"
        in 7..10 -> "Nivel meritorio"
        else -> "Puntaje inválido"
    }
}

// Calcula el dinero a recibir según puntos y salario
fun calcularDinero(puntos: Int, salario: Double): Double {
    return salario * (puntos / 10.0)
}

// Muestra los resultados finales al usuario
fun mostrarResultados(nivel: String, dinero: Double) {
    println("\nResultado:")
    println("Nivel del empleado: $nivel")
    println("Dinero recibido: %.2f soles".format(dinero))
}