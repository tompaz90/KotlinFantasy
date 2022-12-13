package com.liceolapaz.des.tpp

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class menuBD : AppCompatActivity() {

    var JugadorListDB: List<Jugador> = mutableListOf()
    private lateinit var db: SQLiteDatabase
    private lateinit var adapter : JugadorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_bd)
        val textView: TextView = findViewById(R.id.contador)
        initRecyclerView()
        textView.text = "El numero de jugadores totales es de " + JugadorListDB.size
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


    fun initRecyclerView() {
        recuperarRegistros()
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerJugador)
        adapter = JugadorAdapter(JugadorListDB, onClickListener = {jugador -> seleccionarJugador(jugador)})
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(decoration)
    }


    fun recuperarRegistros(): List<Jugador> {
        val database = SQLiteHelper(this, "jugadores.db", null, 1)
        db = database.writableDatabase
        val c: Cursor = db.rawQuery(" SELECT * FROM jugadores", null)

        if (c.moveToFirst()) {
            do {
                val codigo = c.getInt(0)
                val nombre = c.getString(1)
                val precio = c.getDouble(2)
                val posiciones = c.getString(3)
                val puntos = c.getInt(4)

                val jugador = Jugador(codigo, nombre, precio, posiciones, puntos)
                JugadorListDB += jugador
            } while (c.moveToNext());
        }
            db.close()
            return JugadorListDB
        }

    private fun seleccionarJugador(jugador : Jugador) {

        val intent = Intent(this@menuBD, ModificarJugador::class.java)
        intent.putExtra("Codigo", jugador.codigo.toString())
        intent.putExtra("nombre", jugador.nombre)
        intent.putExtra("precio", jugador.precio.toString())
        intent.putExtra("posicion", jugador.posicion)
        intent.putExtra("puntos", jugador.puntos.toString())
        startActivity(intent)

    }

}
