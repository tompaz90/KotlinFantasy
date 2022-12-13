package com.liceolapaz.des.tpp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(context : Context?, name: String?, factory:CursorFactory?, version: Int)
    : SQLiteOpenHelper (context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE jugadores (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, precio DOUBLE, posicion TEXT, puntos INTEGER)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS jugadores")
        onCreate(db)
    }




}