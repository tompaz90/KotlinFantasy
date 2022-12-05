package com.liceolapaz.des.tpp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;



public class SQLite_OpenHelper extends SQLiteOpenHelper {

    public SQLite_OpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
        public void onCreate(SQLiteDatabase db) {
            //Se ejecuta la sentencia SQL de creación de la tabla
            db.execSQL("CREATE TABLE Usuarios (usuario TEXT, password TEXT)");
            db.execSQL("INSERT INTO Usuarios VALUES (admin, liceo)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
            db.execSQL("DROP TABLE IF EXISTS Usuarios");
            db.execSQL("CREATE TABLE Usuarios (usuario TEXT, password TEXT)");
            db.execSQL("INSERT INTO Usuarios VALUES (admin, liceo)");
    }

}

