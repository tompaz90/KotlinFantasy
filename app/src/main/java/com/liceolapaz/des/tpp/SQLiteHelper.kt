package com.liceolapaz.des.tpp

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

    private var jugadorList: List<Jugador> = TODO()

class SQLiteHelper(context : Context) : SQLiteOpenHelper (context, "jugadores.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE jugadores (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, precio DOUBLE, posicion TEXT, puntos INTEGER)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS jugadores")
        onCreate(db)
    }

    fun insertarRegistro(nombres: String, precios: Int, posicion: String, puntuacion: Int) {
        val db = this.writableDatabase
        db!!.execSQL("INSERT INTO jugadores (nombre, precio, posicion, puntos) VALUES ($nombres, $precios, $posicion, $puntuacion")
    }

    fun recuperarRegistros() {
        var codigo: Int
        var nombre: String
        var precio: Double
        var posiciones: String
        var puntos: Int

        val db = readableDatabase
        val c: Cursor = db!!.rawQuery(" SELECT * FROM jugadores", null)

        if (c.moveToFirst()) {
            codigo = c.getInt(0)
            nombre = c.getString(1)
            precio = c.getDouble(2)
            posiciones = c.getString(3)
            puntos = c.getInt(4)

            jugadorList = listOf<Jugador>(
                Jugador(
                    codigo,
                    nombre,
                    precio,
                    posiciones,
                    puntos
                )
            )
        }
        while (c.moveToNext()) {
        }
    }
}