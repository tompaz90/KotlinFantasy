package com.liceolapaz.des.tpp

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class AnadirJugador : AppCompatActivity() {

    private lateinit var nombre : EditText
    private lateinit var precio : EditText
    private lateinit var posiciones : Spinner
    private lateinit var puntos : EditText
    private lateinit var aceptarBtn : Button
    private lateinit var cancelarBtn : Button
    lateinit var jugadoresDB : SQLiteDatabase

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
        val database = SQLiteHelper(this, "jugadores.db", null, 1)
        jugadoresDB = database.writableDatabase

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
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Confirmar")
                builder.setMessage("Desea actualizar la base de datos?")
                builder.setPositiveButton("Aceptar", object: DialogInterface.OnClickListener{

                    override fun onClick(dialogo: DialogInterface?, which: Int) {
                        val nombre2 = nombre.text.toString()
                        val precio2 = precio.text.toString().toDouble()
                        val posicion2 = posiciones.selectedItem.toString()
                        val puntos2 = puntos.text.toString().toInt()

                        jugadoresDB.execSQL("INSERT INTO jugadores (nombre, precio, posicion, puntos) VALUES ('$nombre2', '$precio2', '$posicion2', '$puntos2')")
                        val intent = Intent(this@AnadirJugador, menuBD::class.java)
                        startActivity(intent)
                    }

                })
                builder.setNegativeButton("Cancelar") {
                        dialog, which ->
                    val intent = Intent(this@AnadirJugador, menuBD::class.java)
                    startActivity(intent)
                }
                builder.show()
                }


            }
        }



