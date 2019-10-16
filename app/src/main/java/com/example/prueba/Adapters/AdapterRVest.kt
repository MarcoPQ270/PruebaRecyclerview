package com.example.prueba.Adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba.Activity2
import com.example.prueba.R
import com.example.prueba.dataclasses.Estudiantes

class AdapterRVest internal  constructor(context: Context):
    RecyclerView.Adapter<AdapterRVest.estviewHolder>() {

    private val inflater:LayoutInflater= LayoutInflater.from(context)
    private var ListaEst= emptyList<Estudiantes>()

    fun setDataToList(lista:List<Estudiantes>){
        this.ListaEst=lista
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): estviewHolder {
        val itemView=inflater.inflate(R.layout.recycler_item,parent,false)
        return estviewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return ListaEst.size
    }

    override fun onBindViewHolder(holder: estviewHolder, position: Int) {
        holder.nombre.text=ListaEst.get(position).nombreest
        holder.semestre.text=ListaEst.get(position).semestre
        holder.carrera.text=ListaEst.get(position).carrera
        holder.edad.text=ListaEst.get(position).edad
        var intent = Intent(inflater.context, Activity2::class.java)

        holder.card.setOnClickListener{
        val context=inflater.context as Activity
            context.startActivity(intent)
        }

    }
    //primero creamos la inner class
    inner class estviewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val card= itemView.findViewById<ConstraintLayout>(R.id.itemCard)
        val nombre= itemView.findViewById<TextView>(R.id.item_nom)
        val semestre=itemView.findViewById<TextView>(R.id.item_semestre)
        val carrera=itemView.findViewById<TextView>(R.id.item_carrera)
        val edad=itemView.findViewById<TextView>(R.id.item_edad)
    }
}