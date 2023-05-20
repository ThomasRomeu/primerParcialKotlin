package com.example.primerparcial_thomasromeu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter
    private lateinit var buttonToRegistroAlumno: Button

    private var userName: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonToRegistroAlumno = findViewById(R.id.buttonToRegistro)

        buttonToRegistroAlumno.setOnClickListener{
            val intent = Intent(this, RegistroAlumno::class.java)
            startActivity(intent)
        }

        val preferences = getSharedPreferences("alumnoPref", MODE_PRIVATE)
        userName = preferences.getString("nombre", "")

        recyclerView = findViewById(R.id.recyclerViewAlumno)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = Adapter(applicationContext)
        recyclerView.adapter = adapter

        adapter.submitList(listadoAlumnos())
        adapter.onItemClickListener = { alumno ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("nombre", alumno.nombre)
            intent.putExtra("url", alumno.url)
            intent.putExtra("edad", alumno.edad)
            startActivity(intent)
        }
    }

    private fun listadoAlumnos(): MutableList<Alumno>? {

        return mutableListOf(
            Alumno(
                1,
                userName,
                25,
                "https://www.pngall.com/wp-content/uploads/12/Avatar-Profile-Vector-PNG-File.png"
            ), Alumno(
                2,
                "Ludmila",
                20,
                "https://w7.pngwing.com/pngs/193/660/png-transparent-computer-icons-woman-avatar-avatar-girl-thumbnail.png"
            ),Alumno(
                3,
                "Pedro",
                29,
                "https://w7.pngwing.com/pngs/481/915/png-transparent-computer-icons-user-avatar-woman-avatar-computer-business-conversation-thumbnail.png"
            ),
            Alumno(
                4,
                "Maria",
                47,
                "https://w7.pngwing.com/pngs/843/694/png-transparent-avatar-female-cartoon-avatar-purple-face-black-hair-thumbnail.png"
            ),
            Alumno(
                5,
                "Lucia",
                35,
                "https://w7.pngwing.com/pngs/555/703/png-transparent-computer-icons-avatar-woman-user-avatar-face-heroes-service-thumbnail.png"
            ),
            Alumno(
                6,
                "Julian",
                30,
                "https://w7.pngwing.com/pngs/954/328/png-transparent-computer-icons-user-profile-avatar-heroes-head-recruiter-thumbnail.png"
            ),
            Alumno(
                7,
                "Nelson",
                21,
                "https://w7.pngwing.com/pngs/980/886/png-transparent-male-portrait-avatar-computer-icons-icon-design-avatar-flat-face-icon-people-head-cartoon-thumbnail.png"
            ),
            Alumno(
                8,
                "Matias",
                28,
                "https://w7.pngwing.com/pngs/646/829/png-transparent-avatar-man-ico-icon-cartoon-little-boy-avatar-cartoon-character-png-material-child-thumbnail.png"
            ),
            Alumno(
                9,
                "Paloma",
                18,
                "https://w7.pngwing.com/pngs/749/780/png-transparent-female-avatar-cartoon-user-avatar-purple-face-heroes-thumbnail.png"
            ),
            Alumno(
                10,
                "Joaquin",
                21,
                "https://w7.pngwing.com/pngs/312/283/png-transparent-man-s-face-avatar-computer-icons-user-profile-business-user-avatar-blue-face-heroes-thumbnail.png"
            ),
        )
    }
}