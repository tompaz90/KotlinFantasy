package com.liceolapaz.des.tpp

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class ModificarJugador : AppCompatActivity() {

    private lateinit var codigo: EditText
    private lateinit var nombre: EditText
    private lateinit var precio: EditText
    private lateinit var posiciones: Spinner
    private lateinit var puntos: EditText
    private lateinit var eliminarBtn: Button
    private lateinit var cancelarBtn: Button
    private lateinit var modificarBtn: Button
    lateinit var jugadoresDB: SQLiteDatabase

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.modificar_jugador)

        codigo = findViewById(R.id.editTextCodigo)
        nombre = findViewById(R.id.editTextNombre)
        precio = findViewById(R.id.editTextPrecio)
        posiciones = findViewById(R.id.editTextPosiciones)
        puntos = findViewById(R.id.editTextPuntos)
        eliminarBtn = findViewById(R.id.BtnEliminar)
        cancelarBtn = findViewById(R.id.BtnCancelar)
        modificarBtn = findViewById(R.id.BtnModificar)
        val database = SQLiteHelper(this, "jugadores.db", null, 1)
        jugadoresDB = database.writableDatabase

        val adaptador =
        ArrayAdapter.createFromResource(
            this, R.array.posiciones,
            android.R.layout.simple_spinner_item
        )
        adaptador.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        posiciones.adapter = adaptador



        eliminarBtn.setOnClickListener() {
            crearDialogoEliminar()
        }



        modificarBtn.setOnClickListener() {
            crearDialogoModificar()
        }


        cancelarBtn.setOnClickListener() {
            val intent = Intent(this@ModificarJugador, menuBD::class.java)
            startActivity(intent)

            val adaptador =
                ArrayAdapter.createFromResource(
                    this, R.array.posiciones,
                    android.R.layout.simple_spinner_item
                )
            adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
            )
            posiciones.adapter = adaptador
        }
    }

    fun crearDialogoModificar()  {
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

                    jugadoresDB.execSQL("UPDATE FROM jugadores SET nombre = '$nombre2' WHERE codigo = '$codigo' ")
                    jugadoresDB.execSQL("UPDATE FROM jugadores SET precio = '$precio2' WHERE codigo = '$codigo' ")
                    jugadoresDB.execSQL("UPDATE FROM jugadores SET posicion = '$posicion2' WHERE codigo = '$codigo' ")
                    jugadoresDB.execSQL("UPDATE FROM jugadores SET puntos = '$puntos2' WHERE codigo = '$codigo' ")
                    val intent = Intent(this@ModificarJugador, menuBD::class.java)
                    startActivity(intent)
                }
            })

            builder.setNegativeButton("Cancelar") {
                    dialog, which ->
                val intent = Intent(this@ModificarJugador, menuBD::class.java)
                startActivity(intent)
            }
            builder.show()
        }
    }

    fun crearDialogoEliminar()  {
        if (nombre.text.isNotBlank() && precio.text.isNotBlank() && puntos.text.isNotBlank()) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Confirmar")
            builder.setMessage("Desea actualizar la base de datos?")
            builder.setPositiveButton("Aceptar", object: DialogInterface.OnClickListener{

                override fun onClick(dialogo: DialogInterface?, which: Int) {
                    val intent = Intent(this@ModificarJugador, menuBD::class.java)
                    jugadoresDB.execSQL("DELETE FROM jugadores WHERE codigo = '$codigo'")
                    startActivity(intent)
                }
            })

            builder.setNegativeButton("Cancelar") {
                    dialog, which ->
                val intent = Intent(this@ModificarJugador, menuBD::class.java)
                startActivity(intent)
            }
            builder.show()
        }


    }

}