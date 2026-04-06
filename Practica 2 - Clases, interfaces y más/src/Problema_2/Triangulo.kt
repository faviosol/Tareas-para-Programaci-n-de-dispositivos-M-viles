package Problema_2
//Extendemos con : de la abstract class Shape
class Triangulo (var base: Double,var altura: Double,var lado: Double): Shape() {
    override fun calcularArea(): Double {
        return (base * altura)/2
    }

    override fun calcularPerimetro(): Double {
        return lado * 3
    }

    override fun toString(): String {
        val area = (base * altura)/2
        val perimetro = lado * 3
        return "Area: $area \nPerimetro: $perimetro"
    }
}