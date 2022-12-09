package com.liceolapaz.des.tpp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {

    private lateinit var user : EditText
    private lateinit var password : EditText
    private lateinit var loginButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        user = findViewById(R.id.user)
        password = findViewById(R.id.password)
        loginButton = findViewById(R.id.loginButton)

        loginButton.setOnClickListener() {
            if (user.text.toString().equals("admin") && password.text.toString().equals("liceo")) {
                    val intent = Intent(this@MainActivity, menuBD::class.java)
                    startActivity(intent)
                }
            }
        }
    }
