/*
Comentarios del problema: Se trata sobre hacer un sistema que gestione los libros y revistas, para gestionar la biblioteca
Autor: Favio Andre Solórzano Vilca
Fecha de creación: 5/04/2026 | Fecha de modificación: NA
*/

//Contiene la clase Biblioteca y el Problema_1.main [f y g]
package Problema_3

class Biblioteca : IBiblioteca {

    private val materialesDisponibles = mutableListOf<Material>()
    private val materialesPrestados = mutableMapOf<Usuario, MutableList<Material>>()

    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
    }

    override fun registrarUsuario(usuario: Usuario) {
        materialesPrestados[usuario] = mutableListOf()
    }

    override fun prestamo(usuario: Usuario, material: Material) {
        when {
            !materialesPrestados.containsKey(usuario) ->
                println("Usuario ${usuario.nombre} no registrado")
            !materialesDisponibles.contains(material) ->
                println("${material.titulo} no disponible")
            else -> {
                materialesDisponibles.remove(material)
                materialesPrestados[usuario]?.add(material)
                println("Prestamo: ${material.titulo} a ${usuario.nombre}")
            }
        }
    }

    override fun devolucion(usuario: Usuario, material: Material) {
        when {
            !materialesPrestados.containsKey(usuario) ->
                println("Usuario ${usuario.nombre} no registrado")
            !materialesPrestados[usuario]!!.contains(material) ->
                println("${usuario.nombre} no tiene ${material.titulo}")
            else -> {
                materialesPrestados[usuario]?.remove(material)
                materialesDisponibles.add(material)
                println("Devolucion: ${material.titulo} de ${usuario.nombre}")
            }
        }
    }

    override fun mostrarMaterialesDisponibles() {
        println("\n── Materiales disponibles ──")
        if (materialesDisponibles.isEmpty()) {
            println("No hay materiales disponibles")
            return
        }
        materialesDisponibles.forEach { it.mostrarDetalles() }
    }

    override fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario) {
        println("\n── Materiales de ${usuario.nombre} ${usuario.apellido} ──")
        val lista = materialesPrestados[usuario]
        if (lista.isNullOrEmpty()) {
            println("${usuario.nombre} no tiene materiales en prestamo")
            return
        }
        lista.forEach { it.mostrarDetalles() }
    }
}

fun main() {
    val biblioteca = Biblioteca()

    // libros de programación
    val libroC = Libro("El Lenguaje de Programacion C", "Dennis Ritchie", 1978, "Sistemas", 288)
    val libroLinux = Libro("The Linux Programming Interface", "Michael Kerrisk", 2010, "Sistemas", 1506)
    val libroRust = Libro("The Rust Programming Language", "Steve Klabnik", 2019, "Sistemas", 560)
    val libroUnix = Libro("UNIX: A History and a Memoir", "Brian Kernighan", 2020, "Historia", 224)

    // revistas de programación
    val revistaLinux = Revista("Linux Journal", "Various", 2024, 10928, 30, 5, "Belltown Media")
    val revistaACM = Revista("Communications of the ACM", "ACM", 2024, 10782, 67, 3, "ACM Press")

    // usuarios
    val favio = Usuario("Favio", "Solorzano", 20)
    val brian = Usuario("Brian", "Kernighan", 55)
    val linus = Usuario("Linus", "Torvalds", 54)

    // registrar materiales
    biblioteca.registrarMaterial(libroC)
    biblioteca.registrarMaterial(libroLinux)
    biblioteca.registrarMaterial(libroRust)
    biblioteca.registrarMaterial(libroUnix)
    biblioteca.registrarMaterial(revistaLinux)
    biblioteca.registrarMaterial(revistaACM)

    // registrar usuarios
    biblioteca.registrarUsuario(favio)
    biblioteca.registrarUsuario(brian)
    biblioteca.registrarUsuario(linus)

    // mostrar todo disponible al inicio
    biblioteca.mostrarMaterialesDisponibles()

    // préstamos
    biblioteca.prestamo(favio, libroLinux)
    biblioteca.prestamo(favio, libroRust)
    biblioteca.prestamo(brian, libroC)
    biblioteca.prestamo(linus, revistaLinux)

    // mostrar después de préstamos
    biblioteca.mostrarMaterialesDisponibles()
    biblioteca.mostrarMaterialesReservadosPorUsuario(favio)
    biblioteca.mostrarMaterialesReservadosPorUsuario(brian)
    biblioteca.mostrarMaterialesReservadosPorUsuario(linus)

    // mostrar estado final
    biblioteca.mostrarMaterialesDisponibles()
    biblioteca.mostrarMaterialesReservadosPorUsuario(favio)
}