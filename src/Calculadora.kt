/*
Problema 3 - Calculadora con menú
Autor: Favio André Solórzano Vilca
Fecha de creación: 25/03/2026
Fecha de modificación: 29/03/2026
Descripción: Calculadora básica con menú de opciones.
*/

// Muestra el menú y devuelve la opción elegida
fun menu(): Int {
    println("==== MENÚ ====")
    println("1. Suma")
    println("2. Resta")
    println("3. Multiplicación")
    println("4. División")
    println("5. Salir")
    print("Elige una opción: ")
    return readln().toInt()
}

// Solicita números y ejecuta la operación
fun ingresarNumeros(opcion: Int) {
    print("Ingresa el primer número: ")
    val num1 = readln().toDouble()

    print("Ingresa el segundo número: ")
    val num2 = readln().toDouble()

    when (opcion) {
        1 -> suma(num1, num2)
        2 -> resta(num1, num2)
        3 -> multiplicacion(num1, num2)
        4 -> division(num1, num2)
        else -> println("Opción inválida")
    }
}

// Operaciones
fun suma(num1: Double, num2: Double) {
    println("Resultado: ${num1 + num2}")
}

fun resta(num1: Double, num2: Double) {
    println("Resultado: ${num1 - num2}")
}

fun multiplicacion(num1: Double, num2: Double) {
    println("Resultado: ${num1 * num2}")
}

fun division(num1: Double, num2: Double) {
    if (num2 == 0.0) {
        println("Error: no se puede dividir entre cero")
    } else {
        println("Resultado: ${num1 / num2}")
    }
}

// Controla el flujo del programa
fun calculadora() {
    var opcion: Int

    do {
        opcion = menu()
        if (opcion != 5) {
            ingresarNumeros(opcion)
        }
    } while (opcion != 5)

    println("Programa finalizado")
}

// Función principal
fun main() {
    calculadora()
}