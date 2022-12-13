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
        posiciones = findViewById(R.id.SpinnerPosiciones)
        puntos = findViewById(R.id.editTextPuntos)
        eliminarBtn = findViewById(R.id.BtnEliminar)
        cancelarBtn = findViewById(R.id.BtnCancelar)
        modificarBtn = findViewById(R.id.BtnModificar)
        val database = SQLiteHelper(this, "jugadores.db", null, 1)
        jugadoresDB = database.writableDatabase

        codigo.setText(intent.getStringExtra("Codigo"))
        nombre.setText(intent.getStringExtra("nombre"))
        precio.setText(intent.getStringExtra("precio"))
        val adaptador =
            ArrayAdapter.createFromResource(
                this, R.array.posiciones,
                android.R.layout.simple_spinner_item
            )
        adaptador.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        posiciones.adapter = adaptador

        if (intent.getStringExtra("posicion").contentEquals("Portero (PT)")) {
            posiciones.setSelection(0)
        }

        if (intent.getStringExtra("posicion").contentEquals("Defensa (DF)")) {
            posiciones.setSelection(1)
        }

        if (intent.getStringExtra("posicion").contentEquals("Mediocampista (MC)")) {
            posiciones.setSelection(2)
        }

        if (intent.getStringExtra("posicion").contentEquals("Delantero (DL)")) {
            posiciones.setSelection(3)
        }

        puntos.setText(intent.getStringExtra("puntos"))







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
                    val codigo2 = codigo.text.toString()

                    jugadoresDB.execSQL("UPDATE jugadores SET nombre = '$nombre2' WHERE id = '$codigo2' ")
                    jugadoresDB.execSQL("UPDATE jugadores SET precio = '$precio2' WHERE id = '$codigo2' ")
                    jugadoresDB.execSQL("UPDATE jugadores SET posicion = '$posicion2' WHERE id = '$codigo2' ")
                    jugadoresDB.execSQL("UPDATE jugadores SET puntos = '$puntos2' WHERE id = '$codigo2' ")
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
                    val codigo1 = codigo.text.toString()
                    jugadoresDB.execSQL("DELETE FROM jugadores WHERE id = '$codigo1'")
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