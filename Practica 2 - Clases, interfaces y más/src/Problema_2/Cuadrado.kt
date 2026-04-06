package Problema_2
//Extendemos con : de la abstract class Shape
class Cuadrado (var lado: Double): Shape() {
    override fun calcularArea(): Double {
        return lado * lado
    }

    override fun calcularPerimetro(): Double {
        return lado * 4
    }

    override fun toString(): String {
        val area = lado * lado
        val perimetro = lado * 4
        return "Area: $area \nPerimetro: $perimetro"
    }
}