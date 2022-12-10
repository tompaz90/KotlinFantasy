package com.liceolapaz.des.tpp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(context: Context) : SQLiteOpenHelper (context, "jugadores.db", null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE jugadores (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, precio INTEGER, posicion TEXT, puntos INTEGER)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS jugadores")
        onCreate(db)
    }

    fun insertarRegistro(nombres: String, precios: Int, posicion: String, puntuacion: Int) {
        val db = this.writableDatabase
        db!!.execSQL("INSERT INTO jugadores (nombre, precio, posicion, puntos) VALUES ($nombres, $precios, $posicion, $puntuacion")
    }
}