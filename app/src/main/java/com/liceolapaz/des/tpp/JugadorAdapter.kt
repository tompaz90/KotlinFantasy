package com.liceolapaz.des.tpp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class JugadorAdapter(private val jugadorList: List<Jugador>) : RecyclerView.Adapter<JugadorViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JugadorViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return JugadorViewHolder(layoutInflater.inflate(R.layout.jugador_rv, parent, false))
    }

    override fun onBindViewHolder(holder: JugadorViewHolder, position: Int) {
        val item = jugadorList[position]
        holder.render(item)
    }


    override fun getItemCount(): Int = jugadorList.size

}