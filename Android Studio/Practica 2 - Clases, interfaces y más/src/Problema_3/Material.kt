package Problema_3
//Contenido del paquete: 1 clase abstracta Material y 2 subclases Libro y Revista.[a,b y c]
abstract class Material(val titulo: String, val autor: String, val anioPublicacion: Int) {
    abstract fun mostrarDetalles()
}

class Libro (titulo: String, autor: String, anioPublicacion: Int, val genero: String, val numeroPaginas: Int) : Material(titulo, autor, anioPublicacion){
    override fun mostrarDetalles() {
        println("Libro: $titulo")
        println("Autor: $autor")
        println("Año: $anioPublicacion")
        println("Genero: $genero")
        println("NumeroPaginas: $numeroPaginas")
    }
}

class Revista (titulo: String, autor: String, anioPublicacion: Int, val issn: Int, val volumen: Int, val numero: Int, val editorial: String) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("Libro: $titulo")
        println("Autor: $autor")
        println("Año: $anioPublicacion")
        println("ISSN: $issn")
        println("Volumen: $volumen")
        println("Numero: $numero")
        println("Editorial: $editorial")
    }
}

