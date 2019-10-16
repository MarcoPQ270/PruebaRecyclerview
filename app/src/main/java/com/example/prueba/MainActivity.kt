package com.example.prueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba.Adapters.AdapterRVest
import com.example.prueba.dataclasses.Estudiantes

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_main)
        //llenamos la lista
        val lista= listOf<Estudiantes>(
            Estudiantes("Marco","7", "Tics", "21"),
            Estudiantes("Mauricio","7", "Tics", "21"),
            Estudiantes("Didiere","7", "Tics", "21"),
            Estudiantes("Juan","7", "Tics", "21"),
            Estudiantes("Marco","7", "Tics", "21"),
            Estudiantes("Mauricio","7", "Tics", "21"),
            Estudiantes("Didiere","7", "Tics", "21"),
            Estudiantes("Juan","7", "Tics", "21")
            )
        val recycler = findViewById<RecyclerView>(R.id.recyclerest)
        val adapter=AdapterRVest(this)
        recycler.adapter=adapter
        recycler.layoutManager = LinearLayoutManager(this)
       //recycler.layoutManager=GridLayoutManager(this,2)
        adapter.setDataToList(lista)
    }
}
