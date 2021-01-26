package com.example.musicstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tipo_instrumento.*

class TipoInstrumento : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tipo_instrumento)

        val bundle : Bundle? = intent.extras

        bundle?.let { bundleLibriDeNull->
            val imgTipo = bundleLibriDeNull.getInt("dato1")
            val txtTitulo = bundleLibriDeNull.getString("dato2")
            val txtDescripcion = bundleLibriDeNull.getString("dato3")

            imagenTipo.setImageResource(imgTipo)
            textoTitulo.text = "$txtTitulo"
            textoDescripcion.text = "$txtDescripcion"

        }
    }
}