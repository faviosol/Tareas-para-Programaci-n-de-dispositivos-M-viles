package Problema_1/*
Comentarios del problema: Se trata de calcular un descuento a partir de una clase llamada Problema_1.Persona, con atributos como
nombreProducto, precio y descuento.
Autor: Favio Andre Solórzano Vilca
Fecha de creación: 5/04/2026 | Fecha de modificación: NA
*/

//Aqui Asigno 2 atributos val en el constructor principal son nombreProducto y precio.
class Persona(val nombreProducto: String, val precio: Double) {
    //Creo un atributo secundario variable inicializado en 0.0 para el descuento.
    var descuento: Double = 0.0
        /*
        Creamos los métodos get y set para modificar o llamar al descuento.
        En el caso de set añadimos validaciones para ceñirnos al enunciado del problema.
        */
        get() { return field }
        set(value) {
            require(value > 0.0) {"Debe aplicarse un descuento"}
            field = value }
    //Función para hacer el cálculo del descuento por producto.
    fun calcularPrecioFinal(): Double {
        return precio - (precio * descuento / 100)
    }
}
fun main() {
    //Instancio el objeto Persona1 para probar las funcionalidades de la clase.
    val Persona1 = Persona("Peras", 5.8)
    println("Nombre del producto: ${Persona1.nombreProducto}")
    println("Precio del producto: ${Persona1.precio}")
    Persona1.descuento = 15.0
    println("Descuento del producto: %${Persona1.descuento}")
    println("Cantidad a descontar: Se descontarán ${"%.2f".format(Persona1.precio-Persona1.calcularPrecioFinal())} soles")
    println("Precio final del producto: ${Persona1.calcularPrecioFinal()}")
}