package com.liceolapaz.des.tpp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JugadorViewHolder(view: View) : RecyclerView.ViewHolder(view){

    val nombre = view.findViewById<TextView>(R.id.tvNombre)
    val posicion = view.findViewById<TextView>(R.id.tvPosicion)
    val precio = view.findViewById<TextView>(R.id.tvPrecio)
    val puntos = view.findViewById<TextView>(R.id.tvPuntos)

    fun render(jugador:Jugador){
       nombre.text = jugador.nombre
        posicion.text = jugador.posicion
        precio.text = jugador.precio.toString()
        puntos.text = jugador.puntos.toString()
    }
}