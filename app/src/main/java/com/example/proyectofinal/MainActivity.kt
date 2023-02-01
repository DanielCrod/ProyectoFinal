package com.example.proyectofinal

import SQL.SqliteHelper
import Usuario.Usuario
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var switch : Switch
    private lateinit var layout : RelativeLayout
    private lateinit var title : TextView
    private lateinit var forgot : TextView
    private lateinit var account : TextView
    private lateinit var email : EditText
    private lateinit var btn : Button
    private lateinit var username : EditText
    private lateinit var password : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.login)
        title = findViewById(R.id.title)
        layout = findViewById(R.id.layout)
        switch = findViewById(R.id.switch1)
        forgot = findViewById(R.id.forgot)
        account = findViewById(R.id.registertxt)
        email = findViewById(R.id.email)
        username = findViewById(R.id.user)
        password = findViewById(R.id.password)


        btn.setOnClickListener(this)

        switch.setOnCheckedChangeListener {
                buttonView, isChecked ->
            if (isChecked) {
                layout.setBackgroundResource(R.drawable.bb)
                title.setText("Register")
                forgot.setText("")
                account.setText("")
                email.isVisible = true
            } else {
                layout.setBackgroundResource(R.drawable.aa)
                title.setText("Login")
                forgot.setText("Forgot your password?")
                account.setText("Don't have an account yet?")
                email.isVisible = false
            }
        }
    }

    override fun onClick(v: View?) {
        if (btn.text.toString().equals("Login")) {
                val usuario = Usuario(email.text.toString(), username.text.toString(), password.text.toString())
                val helper = SqliteHelper(this)
                try {
                    helper.insertar(usuario)
                    val intent = Intent(this, BienvenidaActivity::class.java)
                    intent.putExtra("Nombre", usuario.nombre)
                    startActivity(intent)
                } catch (e: java.lang.Exception) {
                    Toast.makeText(this, "Email ya registrado", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_LONG).show()
            }

    }


}