package com.liceolapaz.des.tpp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity

class AnadirJugador : AppCompatActivity() {

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

        aceptarBtn.setOnClickListener(){
            crearDialogo()
        }


        val adaptador =
            ArrayAdapter.createFromResource(
                this, R.array.posiciones,
                android.R.layout.simple_spinner_item
            )
        adaptador.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        posiciones.adapter = adaptador

        cancelarBtn.setOnClickListener() {
            val intent = Intent(this@AnadirJugador, menuBD::class.java)
            startActivity(intent)
        }
    }
    fun crearDialogo()  {
            if (nombre.text.isNotBlank() && precio.text.isNotBlank() && puntos.text.isNotBlank()) {
                //HAY QUE PASARLE LOS ARGUMENTS AL DIALOGO
                //https://www.folkstalk.com/tech/how-to-pass-data-from-activity-to-dialogfragment-solutions/
                //setArguments
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Confirmar")
                builder.setMessage("Desea actualizar la base de datos?")
                builder.setPositiveButton("Aceptar") {
                        dialog, which ->
                    val intent = Intent(this@AnadirJugador, menuBD::class.java)
                    startActivity(intent)
                }
                builder.setNegativeButton("Cancelar") {
                    dialog, which ->
                    val intent = Intent(this@AnadirJugador, menuBD::class.java)
                    startActivity(intent)
                }
                builder.show()
            }
        }

    }

