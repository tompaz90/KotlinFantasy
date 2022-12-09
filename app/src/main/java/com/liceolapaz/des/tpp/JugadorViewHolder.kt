package com.liceolapaz.des.tpp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JugadorViewHolder(view : View) : RecyclerView.ViewHolder(view) {

    val nombre = view.findViewById<TextView>(R.id.lblNombre)
    val posicion = view.findViewById<TextView>(R.id.lblPosicion)
    val precio = view.findViewById<TextView>(R.id.lblPrecio)
    val puntos = view.findViewById<TextView>(R.id.lblPuntos)

    fun render(jugador: Jugador) {
        nombre.text = jugador.nombre
        posicion.text = jugador.posicion
        precio.text = jugador.precio
        puntos.text = jugador.puntos

    }
}