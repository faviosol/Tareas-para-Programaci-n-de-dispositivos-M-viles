/*
* Descripción: Activity que muestra resumen del perfil y permite confirmar o editar
* Autor: Favio André Solórzano Vilca
* Fecha creación: 20/04/2026
* Última modificación: 20/04/2026
*/

package com.solorzano.formulario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class ResumenActivity : AppCompatActivity() {

    private lateinit var tvNombre: TextView
    private lateinit var tvEdad: TextView
    private lateinit var tvCiudad: TextView
    private lateinit var tvCorreo: TextView
    private lateinit var btnConfirmar: Button
    private lateinit var btnVolverEditar: Button

    private var usuarioActual: Usuario? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        // Inicializar vistas
        tvNombre = findViewById(R.id.tvNombre)
        tvEdad = findViewById(R.id.tvEdad)
        tvCiudad = findViewById(R.id.tvCiudad)
        tvCorreo = findViewById(R.id.tvCorreo)
        btnConfirmar = findViewById(R.id.btnConfirmar)
        btnVolverEditar = findViewById(R.id.btnVolverEditar)

        // Recibir el usuario del intent
        usuarioActual = intent.getSerializableExtra("usuario") as? Usuario

        if (usuarioActual != null) {
            mostrarDatos()
        }

        // Click listeners
        btnConfirmar.setOnClickListener {
            confirmar()
        }

        btnVolverEditar.setOnClickListener {
            volverEditar()
        }
    }

    private fun mostrarDatos() {
        usuarioActual?.let {
            tvNombre.text = it.nombre
            tvEdad.text = it.edad
            tvCiudad.text = it.ciudad
            tvCorreo.text = it.correo
        }
    }

    private fun confirmar() {
        Toast.makeText(
            this,
            "Perfil guardado correctamente",
            Toast.LENGTH_SHORT
        ).show()

        // Enviar RESULT_OK y volver
        setResult(RESULT_OK)
        finish()
    }

    private fun volverEditar() {
        // Volver sin enviar resultado
        setResult(RESULT_CANCELED)
        finish()
    }
}