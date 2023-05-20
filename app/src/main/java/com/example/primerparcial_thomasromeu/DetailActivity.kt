package com.example.primerparcial_thomasromeu

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private lateinit var textViewDetail: TextView
    private lateinit var imageView: ImageView
    private lateinit var textViewEdad: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        textViewDetail = findViewById(R.id.textViewDetail)
        textViewEdad = findViewById(R.id.textViewEdad)
        imageView = findViewById(R.id.imageViewDetail)

        val bundle = intent.extras
        val nombre = bundle?.getString("nombre", "")
        val url = bundle?.getString("url") ?: ""
        val edad = bundle?.getInt("edad", 0)

        textViewDetail.text = nombre
        textViewEdad.text = edad.toString() + " " + "Años"

        Glide.with(applicationContext)
            .load(url)
            .into(imageView)
    }
}