package com.example.unsabordiferente.screens.listaPedidos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.unsabordiferente.Clientes
import com.example.unsabordiferente.R
import com.example.unsabordiferente.databinding.PedidosItemsBinding


class ListaPedidoAdapter : ListAdapter<Clientes, ListaPedidoAdapter.ViewHolder>(ListaPedidosDiffCallback()){



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }


    class ViewHolder private constructor(val binding:PedidosItemsBinding) : RecyclerView.ViewHolder(binding.root) {
//        val num :TextView = itemView.findViewById(R.id.numeroUser)
//        val nombre: TextView = itemView.findViewById(R.id.nombre)
//        val cantidad: TextView = itemView.findViewById(R.id.cantidad)
//        val numero: TextView = itemView.findViewById(R.id.contacto)

        fun bind(item: Clientes) {
            binding.cliente = item
            binding.executePendingBindings()
//            val res = itemView.context.resources
//            num.text = 0.toString()
//            nombre.text = item.nombre
//            cantidad.text = "Cantidad: "+ item.cantidad
//            numero.text = "Contacto: "+ item.celular
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = PedidosItemsBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }

    class ListaPedidosDiffCallback : DiffUtil.ItemCallback<Clientes>(){
        override fun areItemsTheSame(oldItem: Clientes, newItem: Clientes): Boolean {
            return oldItem.celular == newItem.celular
        }

        override fun areContentsTheSame(oldItem: Clientes, newItem: Clientes): Boolean {
            return oldItem == newItem
        }

    }
}