package com.example.proyectofinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class BienvenidaActivity : AppCompatActivity() {

    private lateinit var nombre : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        nombre = findViewById(R.id.usuario)

        if (intent.extras != null) {
            if (intent.hasExtra("Nombre")) {
                val n = intent.getStringExtra("Nombre") as String
                nombre.setText(n)
            }
        }
    }
}