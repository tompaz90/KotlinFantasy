package com.liceolapaz.des.tpp

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.DialogFragment

    var codigo = 0
    lateinit var jugadoresDB : SQLiteHelper


class DialogoConfirmar : DialogFragment() {

    fun onCreateDialog (savedInstanceState : Bundle) {
        val builder = AlertDialog.Builder(activity)

        builder.setMessage("Esto es un mensaje de alerta.").setTitle("Información")

            //HAY QUE PONER QUE AÑADA EL REGISTRO
            .setPositiveButton("Aceptar") { dialog, id ->
                dialog.cancel()
                val intent = Intent(context, menuBD::class.java)
                startActivity(intent)
            }
            .setNegativeButton("Cancelar") { dialog, id ->
                dialog.cancel()
                val intent = Intent(context, menuBD::class.java)
                startActivity(intent)
            }

    }


}