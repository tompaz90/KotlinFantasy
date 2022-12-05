package com.liceolapaz.des.tpp

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var txtUsuario : EditText
    private lateinit var txtPassword : EditText
    private lateinit var loginBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtUsuario = findViewById(R.id.user)
        txtPassword = findViewById(R.id.password)
        loginBtn = findViewById(R.id.loginButton)

        loginBtn.setOnClickListener() {
        }


    }


}