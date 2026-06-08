/*
Descripción: Es un proyecto que gestiona cambios entre 2 imágenes predeterminadas y muestro 2 toast.
Autor: Favio Solórzano Vilca
fecha de creación: 11/04/2026 y fecha de modificación: 12/04/2026
*/
package com.solorzano.interaccion.imagenes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.solorzano.interaccion.imagenes.R

class MainActivity : AppCompatActivity() {

    // Variable para controlar el estado de la imagen (alternar)
    var estadoCambiado = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencia a la imagen del diseño XML
        val imagen = findViewById<ImageView>(R.id.img_interactiva)

        // Configuración del evento de clic
        imagen.setOnClickListener {
            if (!estadoCambiado) {
                // Cambia a la segunda imagen
                imagen.setImageResource(R.drawable.imagen_dos)
                Toast.makeText(this, "¡Imagen cambiada!", Toast.LENGTH_SHORT).show()
                estadoCambiado = true
            } else {
                // Regresa a la primera imagen
                imagen.setImageResource(R.drawable.imagen_uno)
                Toast.makeText(this, "Volviste al inicio", Toast.LENGTH_SHORT).show()
                estadoCambiado = false
            }
        }
    }
}