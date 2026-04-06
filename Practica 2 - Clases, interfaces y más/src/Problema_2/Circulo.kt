package Problema_2
//Extendemos con : de la abstract class Shape
class Circulo (val PI: Double, var radio: Double): Shape() {
    override fun calcularArea(): Double {
        return PI * radio * radio
    }

    override fun calcularPerimetro(): Double {
        return 2 * PI * radio
    }

    override fun toString(): String {
        val area = PI * radio * radio
        val perimetro = 2 * PI * radio
        //En este caso quería que solo salgan solo 2 decimales, pero el resto lo rellena con ceros en la compilación.
        return "Area: ${"%2f".format(area)} \nPerimetro: ${"%2f".format(perimetro)}"
    }
}