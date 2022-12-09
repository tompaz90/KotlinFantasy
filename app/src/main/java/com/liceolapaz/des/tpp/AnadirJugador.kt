package com.liceolapaz.des.tpp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class AnadirJugador : AppCompatActivity() {

    var codigo = 0
    private lateinit var nombre : EditText
    private lateinit var precio : EditText
    private lateinit var posiciones : Spinner
    private lateinit var puntos : EditText
    private lateinit var aceptarBtn : Button
    private lateinit var cancelarBtn : Button
    lateinit var jugadoresDB : SQLiteHelper

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anadir_jugador)

        nombre = findViewById(R.id.txtNombre)
        precio = findViewById(R.id.txtPrecio)
        posiciones = findViewById(R.id.posiciones)
        puntos = findViewById(R.id.txtPuntos)
        aceptarBtn = findViewById(R.id.aceptarBtn)
        cancelarBtn = findViewById(R.id.cancelarBtn)
        jugadoresDB = SQLiteHelper(this)

        val adaptador =
            ArrayAdapter.createFromResource(this, R.array.posiciones,
                android.R.layout.simple_spinner_item)
        adaptador.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item)
        posiciones.adapter = adaptador

        cancelarBtn.setOnClickListener() {
            val intent = Intent(this@AnadirJugador, menuBD::class.java)
            startActivity(intent)
        }
        aceptarBtn.setOnClickListener(){
            if (nombre.text.isNotBlank() && precio.text.isNotBlank() && puntos.text.isNotBlank()) {
                codigo++
                       jugadoresDB.insertarRegistro(codigo, nombre.text.toString(), precio.text.toString().toInt(), posiciones.toString(), puntos.toString().toInt())
                        Toast.makeText(this, "El registro se ha insertado correctamente", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, "Es necesario rellenar todos los campos", Toast.LENGTH_LONG).show()
                    }
        }

        }


    }
