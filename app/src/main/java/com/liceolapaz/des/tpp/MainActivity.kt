package com.liceolapaz.des.tpp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {

    private lateinit var user : EditText
    private lateinit var password : EditText
    private lateinit var loginButton : Button
    private lateinit var incorrecto : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var contador = 0

        incorrecto = findViewById(R.id.incorrecto)
        user = findViewById(R.id.user)
        password = findViewById(R.id.password)
        loginButton = findViewById(R.id.loginButton)

        loginButton.setOnClickListener() {
            if (user.text.toString().equals("admin") && password.text.toString().equals("liceo")) {
                    val intent = Intent(this@MainActivity, menuBD::class.java)
                    startActivity(intent)
            } else {
                contador++
                incorrecto.setVisibility(View.VISIBLE);
                if (contador == 3)
                { finishAffinity()}
            }
            }
        }
    }
