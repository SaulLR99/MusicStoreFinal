package com.example.musicstore

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class AdaptadorCustom(var context:Context, items:ArrayList<Instrumentos>, var listener: ClickListener): RecyclerView.Adapter<AdaptadorCustom.ViewHolder>() {

    var items:ArrayList<Instrumentos>? = null
    init {
        this.items = items
    }

    // el archivo xml en viewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptadorCustom.ViewHolder {
       val vista = LayoutInflater.from(context).inflate(R.layout.instrumentos,parent,false)
        val viewHolder = ViewHolder(vista,listener)

        return viewHolder
    }

    override fun onBindViewHolder(holder: AdaptadorCustom.ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.foto?.setImageResource(item?.foto!!)
        holder.nombre?.text = item?.nombre
        holder.descripcion?.text = item?.descripcion

        }



    override fun getItemCount(): Int {
       return items?.count()!!
    }

    class ViewHolder(vista: View, listener: ClickListener):RecyclerView.ViewHolder(vista), View.OnClickListener{
        var vista = vista
        var foto:ImageView? = null
        var nombre:TextView? = null
        var descripcion:TextView? = null
        var listener:ClickListener? = null

        init {
            foto = vista.findViewById(R.id.imgInstrumento)
            nombre = vista.findViewById(R.id.textTipo)
            descripcion = vista.findViewById(R.id.textDescripcion)
            this.listener = listener
            vista.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            this.listener?.onClick(v!!,adapterPosition)
        }

    }
}