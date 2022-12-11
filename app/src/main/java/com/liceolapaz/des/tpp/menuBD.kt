package com.liceolapaz.des.tpp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.liceolapaz.des.tpp.JugadorProvider.Companion.jugadorList

class menuBD : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_bd)
        initRecyclerView()

        val textView: TextView = findViewById(R.id.contador)
        textView.setOnClickListener {
            textView.text = "El numero de jugadores totales es de "+ jugadorList.size}
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_menu_bd, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.anadirJugador -> {
            val intent = Intent(this@menuBD, AnadirJugador::class.java)
            startActivity(intent)
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerJugador)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = JugadorAdapter(JugadorProvider.jugadorList)
    }




}
