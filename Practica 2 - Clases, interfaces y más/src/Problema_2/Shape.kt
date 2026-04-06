/*
Comentarios del problema: Se trata de calcular el área y perímetro de 3 figuras y que cada una formará una clase aparte: triangulo, circulo y cuadrado.
Tomando en cuenta la abstract class Shape.
Autor: Favio Andre Solórzano Vilca
Fecha de creación: 5/04/2026 | Fecha de modificación: NA
*/
package Problema_2
//Uso paquetes para englobar las clases en un solo archivo y que no anden sueltas y confundan.
abstract class Shape() {
    abstract fun calcularArea(): Double
    abstract fun calcularPerimetro(): Double
    override fun toString(): String{
        val area = calcularArea()
        val perimetro = calcularPerimetro()
        return "Area: $area, Perimetro: $perimetro"
    }
}

fun main() {
    // Creamos una lista de "Shapes" (Figuras)
    val figuras: List<Shape> = listOf(
        Triangulo(base = 10.0, altura = 5.0, lado = 10.0),
        Cuadrado(lado = 4.0),
        Circulo(PI = 3.14, radio = 3.0)
    )

    // Acá hice un experimento con for y when haciendo iteraciones y conectando con el when
    for (i in 0..2) {
        when (i) {
            0 -> println("--- Analizando el Triángulo ---")
            1 -> println("\n--- Analizando el Cuadrado ---")
            2 -> println("\n--- Analizando el Círculo ---")
        }

        // Imprimimos la figura que está en esa posición de la lista para acompañar el mensaje.
        println(figuras[i].toString())
    }
}