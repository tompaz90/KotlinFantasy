package com.liceolapaz.des.tpp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.InputBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class menuBD : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_bd)
    initRecyclerView()
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
        val recyclerView = findViewById<RecyclerView>(R.id.recView)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter = JugadorAdapter(jugadoresProvider.jugadoresList)
    }


}
