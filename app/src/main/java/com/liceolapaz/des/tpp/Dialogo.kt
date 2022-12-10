package com.liceolapaz.des.tpp

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment


class Dialogo: DialogFragment() {

    lateinit var jugadoresDB : SQLiteHelper

           fun onCreateDialog(savedInstanceState: Bundle?, nombres: String, precios: Int, posicion:String, puntuacion:Int): Dialog {
                val builder = AlertDialog.Builder(activity)
                builder.setMessage("Desea actualizar la base de datos")
                    .setTitle("Confirmacion")
                    .setPositiveButton("Aceptar") { dialog, id ->
                        Log.i("Dialogos", "Confirmacion Aceptada.")
                        jugadoresDB.insertarRegistro(nombres, precios, posicion, puntuacion)
                        dialog.cancel()
                    }
                    .setNegativeButton(
                        "Cancelar"
                    ) { dialog, id ->
                        Log.i("Dialogos", "Confirmacion Cancelada.")
                        dialog.cancel()
                    }
                return builder.create()
            }
        }




    /*
            //HAY QUE PONER QUE AÑADA EL REGISTRO
            .setPositiveButton("Aceptar") { dialog, id ->
                jugadoresDB.insertarRegistro(nombre, precio, posiciones, puntos)
                val intent = Intent(context, menuBD::class.java)
                startActivity(intent)
                dialog.cancel()
            }
            .setNegativeButton("Cancelar") { dialog, id ->
                dialog.cancel()
                val intent = Intent(context, menuBD::class.java)
                startActivity(intent)
            }*/

