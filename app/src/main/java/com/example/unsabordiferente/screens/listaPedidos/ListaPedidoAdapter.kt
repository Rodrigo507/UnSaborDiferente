package com.example.unsabordiferente.screens.listaPedidos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.unsabordiferente.Clientes
import com.example.unsabordiferente.R

class ListaPedidoAdapter : RecyclerView.Adapter<ListaPedidoAdapter.ViewHolder>() {
    var listado = listOf<Clientes>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = listado.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listado[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val num :TextView = itemView.findViewById(R.id.numeroUser)
        val nombre: TextView = itemView.findViewById(R.id.nombre)
        val cantidad: TextView = itemView.findViewById(R.id.cantidad)
        val numero: TextView = itemView.findViewById(R.id.contacto)

        fun bind(item: Clientes) {
            val res = itemView.context.resources
            num.text = 0.toString()
            nombre.text = item.nombre
            cantidad.text = "Cantidad: "+ item.cantidad
            numero.text = "Contacto: "+ item.celular
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.pedidos_items, parent, false)

                return ViewHolder(view)
            }
        }
    }
}