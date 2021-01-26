package com.example.musicstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Categorias : AppCompatActivity() {

    var lista: RecyclerView? = null
    var adaptador:AdaptadorCustom? = null
    var layoutManager: RecyclerView.LayoutManager? = null   //el diseño

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categorias)

        val instrumentos = ArrayList<Instrumentos>()

        instrumentos.add(Instrumentos("Instrumentos de viento" ,"Producen el sonido por la vibración del aire interior",R.drawable.instrumento_viento))
        instrumentos.add(Instrumentos("Instrumentos de cuerda" ,"Producen el sonido por la vibración de cuerdas",R.drawable.instrumento_cuerda))
        instrumentos.add(Instrumentos("Instrumentos de percusión" ,"Producen el sonido al ser aguitados o golpeados",R.drawable.instrumento_percusion))
        instrumentos.add(Instrumentos("Instrumentos electrónicos" ,"Producen el sonido mediante circuitos electrónicos",R.drawable.instrumento_electrico))



        lista = findViewById(R.id.listaRecycler)
        lista?.setHasFixedSize(true)  //adaptador tamaño de la vista

        layoutManager = LinearLayoutManager(this)
        lista?.layoutManager = layoutManager  // donde se dibuje el layout

        adaptador = AdaptadorCustom(this,instrumentos, object: ClickListener{

            override fun onClick(vista: View, index: Int) {
                Toast.makeText(applicationContext, instrumentos.get(index).nombre, Toast.LENGTH_LONG).show()



                if(index == 0){



                    val imgTipo = R.drawable.viento
                    val textTitulo = "Instrumentos musicales de viento"
                    val textDescripcion = getString(R.string.descripcion_viento)

                    val bundle = Bundle()
                    bundle.apply {
                        putInt("dato1",imgTipo)
                        putString("dato2",textTitulo)
                        putString("dato3",textDescripcion)
                    }

                    val intent = Intent(applicationContext,TipoInstrumento::class.java).apply {
                        putExtras(bundle)
                    }
                    startActivity(intent)
                }

                if(index == 1){



                    val imgTipo = R.drawable.cuerda
                    val textTitulo = "Instrumentos musicales de cuerda"
                    val textDescripcion = getString(R.string.descripcion_cuerda)

                    val bundle = Bundle()
                    bundle.apply {
                        putInt("dato1",imgTipo)
                        putString("dato2",textTitulo)
                        putString("dato3",textDescripcion)
                    }

                    val intent = Intent(applicationContext,TipoInstrumento::class.java).apply {
                        putExtras(bundle)
                    }
                    startActivity(intent)
                }

                if(index == 2){



                    val imgTipo = R.drawable.percusion
                    val textTitulo = "Instrumentos musicales de percusión"
                    val textDescripcion = getString(R.string.descripcion_percusion)

                    val bundle = Bundle()
                    bundle.apply {
                        putInt("dato1",imgTipo)
                        putString("dato2",textTitulo)
                        putString("dato3",textDescripcion)
                    }

                    val intent = Intent(applicationContext,TipoInstrumento::class.java).apply {
                        putExtras(bundle)
                    }
                    startActivity(intent)
                }

                if(index == 3){



                    val imgTipo = R.drawable.electronicos
                    val textTitulo = "Instrumentos musicales electrónicos"
                    val textDescripcion = getString(R.string.descripcion_electronicos)

                    val bundle = Bundle()
                    bundle.apply {
                        putInt("dato1",imgTipo)
                        putString("dato2",textTitulo)
                        putString("dato3",textDescripcion)
                    }

                    val intent = Intent(applicationContext,TipoInstrumento::class.java).apply {
                        putExtras(bundle)
                    }
                    startActivity(intent)
                }

            }
        })

        lista?.adapter = adaptador


    }
}