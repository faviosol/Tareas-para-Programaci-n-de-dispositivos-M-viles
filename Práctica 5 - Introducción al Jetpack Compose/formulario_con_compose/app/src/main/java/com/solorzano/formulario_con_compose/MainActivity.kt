package com.solorzano.formulario_con_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.solorzano.formulario_con_compose.ui.screens.FormularioScreen
import com.solorzano.formulario_con_compose.ui.theme.Formulario_con_composeTheme

/**
 * Actividad principal de la aplicación.
 * Inicializa el tema y lanza la pantalla del formulario.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Formulario_con_composeTheme {
                // Pantalla principal del formulario
                FormularioScreen()
            }
        }
    }
}
