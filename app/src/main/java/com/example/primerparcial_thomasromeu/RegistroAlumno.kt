package com.example.primerparcial_thomasromeu

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegistroAlumno : AppCompatActivity() {

    private lateinit var buttonContinueToLogin : Button
    private lateinit var editTextEnterName: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_alumno)

        buttonContinueToLogin = findViewById(R.id.buttonToLogin)
        editTextEnterName = findViewById(R.id.editTextName)

        buttonContinueToLogin.setOnClickListener {
            if (editTextEnterName.text.isNullOrEmpty()) {
                Toast.makeText(this, "Ingrese un Nombre", Toast.LENGTH_SHORT).show()
            } else {
                val userName = editTextEnterName.text.toString()

                val preferences = getSharedPreferences("alumnoPref", MODE_PRIVATE)
                val editor = preferences.edit()
                editor.putString("nombre", userName)
                editor.apply()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

    }
}