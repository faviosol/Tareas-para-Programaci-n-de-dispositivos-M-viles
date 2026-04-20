/*
* Descripción: Activity para llenar formulario de perfil de usuario
* Autor: Favio André Solórzano Vilca
* Fecha creación: 20/04/2026
* Última modificación: 20/04/2026
*/

package com.solorzano.formulario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts

class FormularioActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etEdad: EditText
    private lateinit var etCiudad: EditText
    private lateinit var etCorreo: EditText
    private lateinit var btnContinuar: Button

    // launcher para recibir resultados de ResumenActivity
    private val activityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            // Limpiar campos si vino de "Confirmar"
            limpiarCampos()
        }
        // Si viene de "Volver a editar", los datos ya están restaurados
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        // Inicializar vistas
        etNombre = findViewById(R.id.etNombre)
        etEdad = findViewById(R.id.etEdad)
        etCiudad = findViewById(R.id.etCiudad)
        etCorreo = findViewById(R.id.etCorreo)
        btnContinuar = findViewById(R.id.btnContinuar)

        // Restaurar datos si hubo rotación de pantalla
        if (savedInstanceState != null) {
            etNombre.setText(savedInstanceState.getString("nombre", ""))
            etEdad.setText(savedInstanceState.getString("edad", ""))
            etCiudad.setText(savedInstanceState.getString("ciudad", ""))
            etCorreo.setText(savedInstanceState.getString("correo", ""))
        }

        // Click listener del botón
        btnContinuar.setOnClickListener {
            enviarDatos()
        }
    }

    private fun enviarDatos() {
        val nombre = etNombre.text.toString()
        val edad = etEdad.text.toString()
        val ciudad = etCiudad.text.toString()
        val correo = etCorreo.text.toString()

        // Validación simple
        if (nombre.isEmpty() || edad.isEmpty() || ciudad.isEmpty() || correo.isEmpty()) {
            android.widget.Toast.makeText(
                this,
                "Completa todos los campos",
                android.widget.Toast.LENGTH_SHORT
            ).show()
            return
        }

        // Crear usuario y enviarlo
        val usuario = Usuario(nombre, edad, ciudad, correo)
        val intent = Intent(this, ResumenActivity::class.java)
        intent.putExtra("usuario", usuario)

        // Usar el launcher para iniciar activity y recibir resultado
        activityLauncher.launch(intent)
    }

    private fun limpiarCampos() {
        etNombre.text.clear()
        etEdad.text.clear()
        etCiudad.text.clear()
        etCorreo.text.clear()
        etNombre.requestFocus()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("nombre", etNombre.text.toString())
        outState.putString("edad", etEdad.text.toString())
        outState.putString("ciudad", etCiudad.text.toString())
        outState.putString("correo", etCorreo.text.toString())
    }
}