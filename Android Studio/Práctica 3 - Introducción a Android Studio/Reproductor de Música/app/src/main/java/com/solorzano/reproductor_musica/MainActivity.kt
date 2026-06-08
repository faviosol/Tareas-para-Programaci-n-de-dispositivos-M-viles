/*
Descripción del main: Implementación de la lógica que conectará con los botones pintados en el xml y también implementa algunas fases del ciclo de vida de una apk
Autor: Favio Solórzano Vilca
fecha de creación: 11/04/2026 y fecha de modificación: 12/04/2026
*/
package com.solorzano.reproductor_musica

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val PICK_AUDIO_REQUEST = 200
    private val TAG = "ReproductorLog"
    private var reproductor: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPlay = findViewById<Button>(R.id.btn_play)
        val btnPause = findViewById<Button>(R.id.btn_pause)
        val btnStop = findViewById<Button>(R.id.btn_stop)

        btnPlay.setOnClickListener {
            if (reproductor == null) {
                abrirSelector()
            } else {
                reproductor?.start()
            }
        }

        btnPause.setOnClickListener {
            if (reproductor?.isPlaying == true) reproductor?.pause()
        }

        btnStop.setOnClickListener {
            liberarReproductor()
        }
    }

    private fun abrirSelector() {
        val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
            type = "audio/*"
        }
        startActivityForResult(intent, PICK_AUDIO_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_AUDIO_REQUEST && resultCode == RESULT_OK) {
            data?.data?.let { uri ->
                prepararYReproducir(uri)
            }
        }
    }

    private fun prepararYReproducir(uri: Uri) {
        try {
            liberarReproductor()
            reproductor = MediaPlayer().apply {
                setDataSource(this@MainActivity, uri)
                prepare()
                start()
            }
            Log.d(TAG, "Canción cargada y sonando")
        } catch (e: Exception) {
            Log.e(TAG, "Error: ${e.message}")
            reproductor = null
        }
    }

    private fun liberarReproductor() {
        reproductor?.apply {
            if (isPlaying) stop()
            release()
        }
        reproductor = null
    }

    override fun onDestroy() {
        super.onDestroy()
        liberarReproductor()
    }
}